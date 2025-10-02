plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.umaytrade.umaytv"
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
    // CloudStream API
    implementation("com.lagradost:cloudstream3:1.5.0") // doğru sürümü repo'dan kontrol etmelisin
}
