package com.lagradost.cloudstream3.turkuaztv.providers

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*
import org.jsoup.nodes.Element

class TurkuazProvider : MainAPI() {
    override var mainUrl = "https://www.turkuaz.tv"
    override var name = "TurkuazTV"
    override val supportedTypes = setOf(TvType.Movie, TvType.TvSeries)
    override var lang = "tr"
    
    override val mainPage = mainPageOf(
        "$mainUrl/filmler" to "Filmler",
        "$mainUrl/diziler" to "Diziler",
        "$mainUrl/belgeseller" to "Belgeseller"
    )

    override suspend fun getMainPage(
        page: Int, 
        request: MainPageRequest
    ): HomePageResponse {
        val url = if (page == 1) request.data else "${request.data}?page=$page"
        val document = app.get(url).document
        
        val items = document.select(".video-item, .movie-item, .series-item").mapNotNull { item ->
            parseMediaItem(item)
        }
        
        return newHomePageResponse(
            list = HomePageList(
                name = request.name,
                list = items,
                isHorizontalImages = true
            ),
            hasNext = true
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val searchUrl = "$mainUrl/ara?q=${query.replace(" ", "+")}"
        val document = app.get(searchUrl).document
        
        return document.select(".search-result, .video-item").mapNotNull { item ->
            parseMediaItem(item)
        }
    }

    override suspend fun load(url: String): LoadResponse {
        val document = app.get(url).document
        
        val title = document.selectFirst("h1.title")?.text() ?: ""
        val poster = document.selectFirst("img.poster")?.attr("src")
        val description = document.selectFirst(".description")?.text()
        
        return newMovieLoadResponse(title, url, TvType.Movie, url) {
            this.posterUrl = poster
            this.plot = description
        }
    }

    private fun parseMediaItem(item: Element): MovieSearchResponse? {
        val titleElement = item.selectFirst("a.title, h3 a, .title a") ?: return null
        val title = titleElement.text()
        val href = titleElement.attr("href")
        val poster = item.selectFirst("img")?.attr("src")
        
        return MovieSearchResponse(
            name = title,
            url = href,
            apiName = this.name,
            type = TvType.Movie,
            posterUrl = poster
        )
    }
}