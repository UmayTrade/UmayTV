package com.lagradost.cloudstream3.turkuaztv.providers

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*
import org.jsoup.nodes.Element

class BelgeselXProvider : MainAPI() {
    override var mainUrl = "https://www.belgeselx.com"
    override var name = "BelgeselX"
    override val supportedTypes = setOf(TvType.Documentary)
    override var lang = "tr"
    
    override val mainPage = mainPageOf(
        "$mainUrl/category/belgeseller/page/" to "Popüler Belgeseller",
        "$mainUrl/category/arsiv-belgeseller/page/" to "Arşiv Belgeseller",
        "$mainUrl/category/tarih-belgeselleri/page/" to "Tarih Belgeselleri",
        "$mainUrl/category/doga-belgeselleri/page/" to "Doğa Belgeselleri",
        "$mainUrl/category/bilim-belgeselleri/page/" to "Bilim Belgeselleri"
    )

    override suspend fun getMainPage(
        page: Int, 
        request: MainPageRequest
    ): HomePageResponse {
        val url = request.data + page
        val document = app.get(url).document
        
        val items = document.select("article.item").mapNotNull { article ->
            parseDocumentary(article)
        }
        
        return newHomePageResponse(
            list = HomePageList(
                name = request.name,
                list = items,
                isHorizontalImages = false
            ),
            hasNext = true
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val searchQuery = query.replace(" ", "+")
        val url = "$mainUrl/?s=$searchQuery"
        val document = app.get(url).document
        
        return document.select("article.item").mapNotNull { article ->
            parseDocumentary(article)
        }
    }

    override suspend fun load(url: String): LoadResponse {
        val document = app.get(url).document
        
        val title = document.selectFirst("h1.entry-title")?.text() ?: ""
        val poster = document.selectFirst("meta[property=og:image]")?.attr("content")
        val description = document.selectFirst(".entry-content p")?.text()
        val year = document.selectFirst("time.entry-date")?.text()?.take(4)?.toIntOrNull()
        
        // Video iframe'lerini bul
        val iframes = document.select("iframe").map { it.attr("src") }
        val videos = mutableListOf<VideoSource>()
        
        iframes.forEach { iframeUrl ->
            if (iframeUrl.isNotBlank()) {
                try {
                    val iframeDoc = app.get(iframeUrl).document
                    extractVideos(iframeDoc)?.let { videoList ->
                        videos.addAll(videoList)
                    }
                } catch (e: Exception) {
                    // Hata durumunda devam et
                }
            }
        }
        
        return newMovieLoadResponse(
            name = title,
            url = url,
            apiName = this.name,
            type = TvType.Documentary
        ) {
            this.posterUrl = poster
            this.plot = description
            this.year = year
            
            videos.forEachIndexed { index, video ->
                addSource("Video ${index + 1}", video.url)
            }
        }
    }

    private fun parseDocumentary(article: Element): MovieSearchResponse? {
        val titleElement = article.selectFirst("h2 a") ?: return null
        val title = titleElement.text()
        val href = titleElement.attr("href")
        val poster = article.selectFirst("img")?.attr("src")
        val description = article.selectFirst(".entry-content p")?.text()
        
        return MovieSearchResponse(
            name = title,
            url = href,
            apiName = this.name,
            type = TvType.Documentary,
            posterUrl = poster,
            plot = description
        )
    }

    private fun extractVideos(document: org.jsoup.nodes.Document): List<VideoSource>? {
        val videoSources = mutableListOf<VideoSource>()
        
        // Direct video sources
        document.select("source[src]").forEach { source ->
            val videoUrl = source.attr("src")
            if (isValidVideoUrl(videoUrl)) {
                videoSources.add(VideoSource(videoUrl, "Direct"))
            }
        }
        
        // M3U8 URLs
        val m3u8Regex = Regex("""(https?://[^"'\s]+\.m3u8[^"'\s]*)""")
        m3u8Regex.findAll(document.html()).forEach { match ->
            videoSources.add(VideoSource(match.value, "HLS"))
        }
        
        // MP4 URLs
        val mp4Regex = Regex("""(https?://[^"'\s]+\.mp4[^"'\s]*)""")
        mp4Regex.findAll(document.html()).forEach { match ->
            videoSources.add(VideoSource(match.value, "MP4"))
        }
        
        return if (videoSources.isNotEmpty()) videoSources else null
    }
    
    private fun isValidVideoUrl(url: String): Boolean {
        return url.contains(Regex("""\.(mp4|m3u8|webm|mkv)""")) && 
               !url.contains("track") && 
               !url.contains("caption")
    }
}