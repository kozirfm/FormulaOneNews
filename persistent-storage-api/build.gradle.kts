plugins {
    id("com.android.library")
    kotlin("android")
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
}