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

repositories{
    google()
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Common.core)
    implementation(Dependencies.Common.appcompat)
    implementation(Dependencies.Common.material)

    //Navigation
    implementation(Dependencies.Navigation.runtime)
    implementation(Dependencies.Navigation.ui)
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.RedMadRobot.extensions)

    //Modules
    implementation(project(Modules.utils))
}