plugins {
    id("com.android.library")
    kotlin("android") version "1.9.24"
}

android {
    namespace = "com.umaytrade.temel"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        aarMetadata {
            minCompileSdk = 21
        }
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
    maven("https://jitpack.io") // CloudStream API burada
}

dependencies {
    implementation("com.github.LagradOst:CloudStream-3:master-SNAPSHOT")
}
