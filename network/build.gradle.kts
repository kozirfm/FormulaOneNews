plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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

    //Dagger 2
    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    //Retrofit
    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.coroutinesAdapter)
    implementation(Dependencies.Retrofit.serializationConverter)
    implementation(Dependencies.OkHttp.core)
    implementation(Dependencies.OkHttp.interceptor)

    //Serialization
    implementation(Dependencies.Serialization.core)

    //Modules
    implementation(project(Modules.core))
    implementation(project(Modules.networkApi))
    //Features
    implementation(project(Features.login))
    implementation(project(Features.news))
    implementation(project(Features.calendar))
    implementation(project(Features.championship))
}