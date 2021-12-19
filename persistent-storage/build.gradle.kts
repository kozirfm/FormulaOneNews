plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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

    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    implementation(Dependencies.Preference.core)

    implementation(project(Modules.base))
    implementation(project(Modules.coreApi))
    implementation(project(Modules.persistentStorageApi))
    implementation(project(Modules.designSystem))
    implementation(project(Modules.utils))
}