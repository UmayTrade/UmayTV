package com.keyiflerolsun

import com.lagradost.cloudstream3.Plugin
import com.lagradost.cloudstream3.registerMainAPI
import com.lagradost.cloudstream3.registerExtractorAPI

class BelgeselXPlugin : Plugin() {
    override fun load() {
        // Burada API’ni kaydet
        registerMainAPI(BelgeselXProvider())

        // Eğer özel extractor kullanıyorsan
        // registerExtractorAPI(MyExtractor())
    }
}
