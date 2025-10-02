plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.keyiflerolsun.belgeselx"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        // Library modüllerde versionCode / versionName kullanılmaz!
        // Eğer aar üretirken version gerekiyorsa gradle.properties ile ayarlanır.
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

    // Yeni Gradle DSL için uyarıyı düzeltelim:
    lint.targetSdk = 34
    testOptions.targetSdk = 34
}

dependencies {
    // Cloudstream3 API
    implementation("com.lagradost:cloudstream3:0.1.0")

    // Kotlin stdlib
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.25")
}
