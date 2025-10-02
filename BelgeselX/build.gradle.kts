plugins {
    kotlin("android") version "1.9.24"
}

android {
    namespace = "com.example.belgeselx"
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
    maven("https://jitpack.io")
}

dependencies {
    // Cloudstream plugin API
    implementation("com.github.LagradOst:CloudStream-3:master-SNAPSHOT")
}
