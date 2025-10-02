package com.example.belgeselx

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class BelgeselXPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(BelgeselXProvider())
    }
}

class BelgeselXProvider : MainAPI() {
    override var mainUrl = "https://belgeselx.com"
    override var name = "BelgeselX"
    override val supportedTypes = setOf(TvType.Movie)

    override suspend fun search(query: String): List<SearchResponse> {
        return listOf(
            MovieSearchResponse(
                "Deneme Belgesel",
                "$mainUrl/deneme",
                TvType.Movie,
                false
            )
        )
    }
}
