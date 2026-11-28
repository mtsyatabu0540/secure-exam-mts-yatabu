// Top-level build file. Konfigurasi dependency ada di app/build.gradle.kts
// dan versi di gradle/libs.versions.toml.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.ksp) apply false
}
