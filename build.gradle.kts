plugins {
    kotlin("jvm") version "1.8.22" apply false
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://jitpack.io") }
    }
}
