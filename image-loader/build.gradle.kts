plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeVersion
        kotlinCompilerVersion = Config.kotlinVersion
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    //Common
    implementation(Dependencies.Common.core)
    //Dagger 2
    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)
    //Coil
    implementation(Dependencies.Coil.core)
    implementation(Dependencies.Coil.compose)
    //Modules
    implementation(project(Modules.core))
}