rootProject.name = "UmayTvPlugins"

// Include all subprojects that have build.gradle.kts files
File(rootDir, ".").listFiles()?.filter { 
    it.isDirectory && 
    File(it, "build.gradle.kts").exists() && 
    it.name != "gradle" &&
    !it.name.startsWith(".")
}?.forEach {
    include(it.name)
}
