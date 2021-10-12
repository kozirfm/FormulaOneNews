object Dependencies {

    object Common {
        const val core = "androidx.core:core-ktx:1.6.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
        const val activity = "androidx.activity:activity-ktx:1.3.1"
        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
        const val fragment = "androidx.fragment:fragment-ktx:1.3.6"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.1.1"
    }

    object Dagger {
        private const val version = "2.38.1"
        const val core = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
    }

    object Navigation {
        private const val version = "2.3.5"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
    }

    object RedMadRobot {
        private const val version = "2.3.1-0"
        const val extensions = "com.redmadrobot.extensions:lifecycle-livedata-ktx:$version"
    }

    object Coroutines {
        private const val version = "1.5.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Serialization {
        private const val version = "1.2.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val coroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
        const val serializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object OkHttp {
        private const val version = "4.8.1"
        const val core = "com.squareup.okhttp3:okhttp:$version"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Coil {
        private const val version = "1.2.2"
        const val core = "io.coil-kt:coil:$version"
    }

    object Lifecycle {
        private const val version = "2.4.0-rc01"
        const val core = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Compose {
        private const val version = "1.0.3"
        const val ui = "androidx.compose.ui:ui:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val material = "androidx.compose.material:material:$version"
        const val iconsCore = "androidx.compose.material:material-icons-core:$version"
        const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
    }
}