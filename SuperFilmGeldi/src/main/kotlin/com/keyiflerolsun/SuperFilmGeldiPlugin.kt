// SUPERFILMGELDIPlugin.kt

package com.keyiflerolsun

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin // << Artık bulunabilir olmalı
import android.content.Context

@CloudstreamPlugin
class SuperFilmGeldiPlugin: Plugin() { // << Artık çalışmalı
    override fun load(context: Context) {
        registerMainAPI(SuperFilmGeldi()) // << Artık çalışmalı
        registerExtractorAPI(BirExtractor())
        registerExtractorAPI(IkinciExtractor())
    }
}
