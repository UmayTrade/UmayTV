// ! Sorun burada değil, doğru paket adını kullanıyorsunuz.
package com.umaytrade

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin // @CloudstreamPlugin için
import com.lagradost.cloudstream3.plugins.Plugin         // Plugin sınıfı için
import android.content.Context

@CloudstreamPlugin
class BelgeselXPlugin: Plugin() { // << Plugin burada bulunamıyor
    override fun load(context: Context) { // << load, Plugin'den gelmediği için hata veriyor
        registerMainAPI(BelgeselX()) // << Unresolved reference
        registerExtractorAPI(Odnoklassniki()) // << Unresolved reference
    }
}
