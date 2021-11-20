plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = Config.compileSdk
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

    //Dagger 2
    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    //Navigation
    implementation(Dependencies.Navigation.ui)
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.RedMadRobot.extensions)

    //Modules
    implementation(project(Modules.core))
    implementation(project(Modules.navigationApi))
    implementation(project(Modules.utils))

    //Features
    implementation(project(Features.login))
    implementation(project(Features.news))
    implementation(project(Features.calendar))
    implementation(project(Features.championship))
}