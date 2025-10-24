package com.umaytv

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class BelgeselX : MainAPI() {
    override var mainUrl = "https://belgeselx.com"
    override var name = "BelgeselX"
    override val hasMainPage = true
    override var lang = "tr"
    override val supportedTypes = setOf(TvType.Documentary)

    override val mainPage = mainPageOf(
        "$mainUrl/belgeseller&page=" to "Tüm Belgeseller"
    )

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val document = app.get("${request.data}${page}").document
        val home = document.select("div.gen-movie-contain").mapNotNull {
            val title = it.selectFirst("h3 a")?.text()?.trim() ?: return@mapNotNull null
            val href = fixUrlNull(it.selectFirst("h3 a")?.attr("href")) ?: return@mapNotNull null
            val posterUrl = fixUrlNull(it.selectFirst("img")?.attr("src"))
            
            newTvSeriesSearchResponse(title, href, TvType.Documentary) {
                this.posterUrl = posterUrl
            }
        }

        return newHomePageResponse(request.name, home)
    }

    override suspend fun search(query: String): List<SearchResponse> {
        return emptyList() // Basit tutmak için şimdilik boş
    }

    override suspend fun load(url: String): LoadResponse? {
        val document = app.get(url).document
        
        val title = document.selectFirst("h2.gen-title")?.text()?.trim() ?: return null
        val poster = fixUrlNull(document.selectFirst("div.gen-tv-show-top img")?.attr("src"))
        val description = document.selectFirst("div.gen-single-tv-show-info p")?.text()?.trim()

        return newTvSeriesLoadResponse(title, url, TvType.Documentary, emptyList()) {
            this.posterUrl = poster
            this.plot = description
        }
    }

    override suspend fun loadLinks(data: String, isCasting: Boolean, subtitleCallback: (SubtitleFile) -> Unit, callback: (ExtractorLink) -> Unit): Boolean {
        // Basit video yükleme
        return false
    }
}
