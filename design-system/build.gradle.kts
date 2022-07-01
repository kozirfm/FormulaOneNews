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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeVersion
    }

}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Common.core)
    implementation(Dependencies.Common.appcompat)
    implementation(Dependencies.Common.material)
    implementation(Dependencies.Common.splash)

    //Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.iconsCore)
    implementation(Dependencies.Compose.iconsExtended)
}