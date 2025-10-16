package com.lagradost.cloudstream3.turkuaztv

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import android.content.Context

@CloudstreamPlugin
class TurkuazTVPlugin : Plugin() {
    override fun load(context: Context) {
        // Tüm provider'ları burada kaydediyoruz
        registerMainAPI(TurkuazProvider())
        registerMainAPI(BelgeselXProvider())
    }
}