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
    implementation(Dependencies.Common.appcompat)
    implementation(Dependencies.Common.material)
    implementation(Dependencies.Common.fragment)
    implementation(Dependencies.Common.activity)
    implementation(Dependencies.Common.activityCompose)

    //Dagger 2
    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    //Coroutines
    implementation(Dependencies.Coroutines.core)

    //Lifecycle
    implementation(Dependencies.Lifecycle.core)
    implementation(Dependencies.Lifecycle.viewModel)

    //Navigation
    implementation(Dependencies.RedMadRobot.extensions)

    //Coil
    implementation(Dependencies.Coil.core)

    //Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.iconsCore)
    implementation(Dependencies.Compose.iconsExtended)

    //Modules
    implementation(project(Modules.core))
    implementation(project(Modules.utils))
    implementation(project(Modules.networkApi))
    implementation(project(Modules.navigationApi))
    implementation(project(Modules.championshipApi))

}