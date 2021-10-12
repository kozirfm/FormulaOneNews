plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk
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

    //Dagger 2
    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    //Navigation
    implementation(Dependencies.Navigation.ui)
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.RedMadRobot.extensions)

    //Modules
    implementation(project(Modules.designSystem))
    implementation(project(Modules.navigationApi))
    implementation(project(Modules.utils))
}