// FilmIzleIlk/build.gradle.kts dosyanıza eklenmesi gereken kısım:

dependencies {
    // Cloudstream Plugin API bağımlılığı
    // Bu, Plugin, registerMainAPI, Score gibi tüm temel Cloudstream sınıflarını sağlayacaktır.
    implementation(project.dependencies.platform("com.lagradost:cloudstream-bom:LATEST_VERSION"))
    implementation("com.lagradost:cloudstream-plugin-api")

    // Kotlin standart kütüphanesi
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

// LATEST_VERSION kısmını projenin ana build.gradle dosyasındaki
// Cloudstream sürüm numarasıyla değiştirmeniz gerekebilir.
