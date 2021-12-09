plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
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

    //Retrofit
    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.coroutinesAdapter)
    implementation(Dependencies.Retrofit.serializationConverter)
    implementation(Dependencies.OkHttp.core)
    implementation(Dependencies.OkHttp.interceptor)

    //Coroutines
    implementation(Dependencies.Coroutines.core)
}