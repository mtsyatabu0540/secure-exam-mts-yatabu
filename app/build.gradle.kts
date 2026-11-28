plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
    // Tidak memakai plugin org.jetbrains.kotlin.android: AGP 9 sudah menyertakan dukungan Kotlin bawaan.
}

android {
    namespace = "id.mtsyatabu.secureexam"
    // compileSdk 37 diwajibkan oleh androidx.core 1.19 (dependency transitif AppCompat/Material).
    compileSdk = 37

    defaultConfig {
        applicationId = "id.mtsyatabu.secureexam"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "0.1.0"
    }

    buildTypes {
        release {
            // Minify/R8 diaktifkan pada tahap rilis, bukan pada kerangka awal.
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }
}

ksp {
    // Ekspor skema Room ke app/schemas (sebaiknya di-commit untuk migrasi di masa depan).
    arg("room.schemaLocation", "$projectDir/schemas")
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.material)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
}
