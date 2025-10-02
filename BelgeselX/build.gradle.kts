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
    // Common modülü yoksa bu satırı kaldır
    // implementation(project(":common"))

    // Cloudstream 3 ana API
    implementation("com.lagradost:cloudstream3:3.0.0")
}
