plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = Config.compileSdk
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
    implementation(Dependencies.Navigation.ui)
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.RedMadRobot.extensions)

    //Modules
    implementation(project(Modules.utils))
}