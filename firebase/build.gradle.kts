plugins {
    id("com.android.library")
    kotlin("android")
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
    implementation(Dependencies.Common.fragment)

    //Firebase
    implementation(platform(Dependencies.Firebase.bom))
    implementation(Dependencies.Firebase.messaging)

    //Modules
    implementation(project(Modules.firebaseApi))
}