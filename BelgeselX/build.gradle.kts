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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Cloudstream ana API JitPack'ten çekilecek
    implementation("com.github.recloudstream:cloudstream:3.2.0")
}
