package com.umaytrade.belgeselx

import android.content.Context
import com.lagradost.cloudstream3.Plugin
import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.utils.AppUtils.registerMainAPI
import com.lagradost.cloudstream3.annotations.CloudstreamPlugin

@CloudstreamPlugin
class BelgeselXPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(BelgeselX())
    }
}

class BelgeselX : MainAPI() {
    override var mainUrl = "https://ornek-belgesel-site.com"
    override var name = "BelgeselX"
    override var lang = "tr"
}
