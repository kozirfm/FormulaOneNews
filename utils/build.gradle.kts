plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
}

android {
    defaultConfig {
        minSdk = Config.minSdk
        compileSdk = Config.compileSdk
        targetSdk = Config.targetSdk
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Common.core)
    implementation(Dependencies.Coroutines.core)

    implementation(Dependencies.Serialization.core)
}