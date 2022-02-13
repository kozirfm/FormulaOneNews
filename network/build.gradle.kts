plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    defaultConfig {
        minSdk = Config.minSdk
        compileSdk = Config.compileSdk
        targetSdk = Config.targetSdk
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

    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.coroutinesAdapter)
    implementation(Dependencies.Retrofit.serializationConverter)
    implementation(Dependencies.Retrofit.scalarsConverter)

    implementation(Dependencies.OkHttp.core)
    implementation(Dependencies.OkHttp.interceptor)

    implementation(Dependencies.Serialization.core)

    implementation(project(Modules.core))
    implementation(project(Modules.networkApi))
    implementation(project(Modules.utils))

}