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

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io") // JitPack ekli
}

dependencies {
    // Cloudstream Plugin API JitPack üzerinden
    implementation("com.github.Lagradost:CloudStream3:3.1.0")
}
