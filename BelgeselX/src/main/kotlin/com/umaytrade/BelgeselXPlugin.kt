package com.umaytrade

import com.lagradost.cloudstream3.Plugin
import com.lagradost.cloudstream3.MainAPI
import android.content.Context

@CloudstreamPlugin
class BelgeselXPlugin: Plugin() {
    override fun load(context: Context) {
        registerMainAPI(BelgeselX())
    }
}

class BelgeselX : MainAPI() {
    override var mainUrl = "https://belgeselx.com/"
    override var name = "BelgeselX"
    override var lang = "tr"
}
