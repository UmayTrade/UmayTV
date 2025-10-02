plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.umaytrade.belgeselx"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }
}

dependencies {
    implementation("com.github.recloudstream:cloudstream:pre-release")
}
