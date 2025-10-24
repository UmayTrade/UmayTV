plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.lagradost.cloudstream3.gradle")
}

android {
    compileSdk = 34
    namespace = "com.umaytv.belgeselx"

    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

cloudstream {
    authors = listOf("UmayTrade")
    language = "tr"
    description = "En yeni belgeseller, türkçe altyazılı yada dublaj olarak 1080p kalitesinde HD belgesel izle."
    status = 1
    tvTypes = listOf("Documentary")
    iconUrl = "https://www.google.com/s2/favicons?domain=belgeselx.com&sz=%size%"
}

dependencies {
    implementation("com.lagradost:cloudstream3:pre-release")
}
