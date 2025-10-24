plugins {
    id("com.android.library") apply false
    id("kotlin-android") apply false
    id("com.lagradost.cloudstream3.gradle") apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
