plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.keyiflerolsun.belgeselx"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // Cloudstream3 API (eklenmezse Plugin sınıfı bulunmaz)
    implementation("com.lagradost:cloudstream3:0.1.0")

    // Kotlin stdlib
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.25")
}
