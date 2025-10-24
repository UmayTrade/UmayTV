version = 1

cloudstream {
    authors     = listOf("UmayTrade")
    language    = "tr"
    description = "En yeni belgeseller, türkçe altyazılı yada dublaj olarak 1080p kalitesinde HD belgesel izle."
    status  = 1
    tvTypes = listOf("Documentary")
    iconUrl = "https://www.google.com/s2/favicons?domain=belgeselx.com&sz=%size%"
}

dependencies {
    implementation(project(":"))
}
