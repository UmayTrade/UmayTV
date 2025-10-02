package com.umaytrade

import android.content.Context
import com.lagradost.cloudstream3.*  // <-- Buradan Plugin ve registerMainAPI geliyor

class TemelPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(TemelProvider())
    }
}

class TemelProvider : MainAPI() {
    override var mainUrl = "https://ornek.com"
    override var name = "Temel"
    override val supportedTypes = setOf(TvType.Movie)

    override suspend fun search(query: String): List<SearchResponse> {
        return listOf(
            MovieSearchResponse(
                name = "Örnek Film",
                url = "$mainUrl/film",
                apiName = this.name,
                type = TvType.Movie,
                posterUrl = null,
                year = 2024
            )
        )
    }
}
