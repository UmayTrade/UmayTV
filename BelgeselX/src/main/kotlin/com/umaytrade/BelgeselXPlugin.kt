package com.umaytrade

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.PluginManager
import com.lagradost.cloudstream3.APIHolder
import com.umaytrade.belgeselx.BelgeselX

@CloudstreamPlugin
class BelgeselXPlugin: CloudstreamPlugin() {
    override fun load(context: PluginManager.Context) {
        // Burada API kaydı yapılır
        APIHolder.registerAPI(BelgeselX())
    }
}
