plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

repositories {
    mavenCentral()
    google()
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeVersion
        kotlinCompilerVersion = Config.kotlinVersion
    }
}

dependencies {
    implementation(Dependencies.Common.core)
    implementation(Dependencies.Common.appcompat)
    implementation(Dependencies.Common.activity)
    implementation(Dependencies.Common.activityCompose)
    implementation(Dependencies.Common.material)
    implementation(Dependencies.Common.constraint)

    //Dagger 2
    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    //Navigation
    implementation(Dependencies.Navigation.ui)
    implementation(Dependencies.Navigation.fragment)

    //Modules
    implementation(project(Modules.core))
    implementation(project(Modules.utils))
    implementation(project(Modules.designSystem))
    implementation(project(Modules.navigation))
    implementation(project(Modules.navigationGraph))
    implementation(project(Modules.navigationApi))
    implementation(project(Modules.news))
    implementation(project(Modules.newsApi))
    implementation(project(Modules.network))
    implementation(project(Modules.networkApi))
    implementation(project(Modules.championship))
    implementation(project(Modules.championshipApi))
}