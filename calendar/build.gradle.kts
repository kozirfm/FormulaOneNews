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
    implementation(Dependencies.Common.fragment)

    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    implementation(Dependencies.Coroutines.core)

    implementation(Dependencies.Lifecycle.core)
    implementation(Dependencies.Lifecycle.viewModel)

    implementation(Dependencies.RedMadRobot.extensions)

    implementation(Dependencies.Coil.core)

    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.iconsCore)
    implementation(Dependencies.Compose.iconsExtended)

    implementation(project(Modules.core))
    implementation(project(Modules.utils))
    implementation(project(Modules.networkApi))
    implementation(project(Modules.navigationApi))
    implementation(project(Modules.imageLoaderApi))
    implementation(project(Modules.designSystem))

    implementation(project(Features.calendarApi))
}