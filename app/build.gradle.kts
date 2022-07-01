plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    kotlin("android")
    kotlin("kapt")
}

repositories {
    mavenCentral()
    google()
}

android {
    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        compileSdk = Config.compileSdk
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeVersion
    }


}

dependencies {
    implementation(Dependencies.Common.core)
    implementation(Dependencies.Common.appcompat)
    implementation(Dependencies.Common.material)
    implementation(Dependencies.Common.constraint)
    implementation(Dependencies.Common.splash)

    //Dagger 2
    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.compiler)

    //Navigation
    implementation(Dependencies.Navigation.runtime)
    implementation(Dependencies.Navigation.ui)
    implementation(Dependencies.Navigation.fragment)

    //Firebase
    implementation(platform(Dependencies.Firebase.bom))
    implementation(Dependencies.Firebase.messaging)

    implementation(Dependencies.Compose.material)

    //Modules
    implementation(project(Modules.core))
    implementation(project(Modules.utils))
    implementation(project(Modules.designSystem))
    implementation(project(Modules.navigation))
    implementation(project(Modules.navigationApi))
    implementation(project(Modules.network))
    implementation(project(Modules.networkApi))
    implementation(project(Modules.imageLoader))
    implementation(project(Modules.imageLoaderApi))
    implementation(project(Modules.firebase))
    implementation(project(Modules.firebaseApi))
    implementation(project(Modules.persistentStorage))
    implementation(project(Modules.persistentStorageApi))

    //Features
    implementation(project(Features.login))
    implementation(project(Features.news))
    implementation(project(Features.calendar))
    implementation(project(Features.calendarApi))
    implementation(project(Features.championship))
    implementation(project(Features.newsDetail))
    implementation(project(Features.newsApi))
}