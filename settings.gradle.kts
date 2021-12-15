pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.5.30")
            }
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.0.2")
            }
            if (requested.id.id.startsWith("androidx.navigation")) {
                useModule("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
            }
            if (requested.id.id.startsWith("com.google.gms")) {
                useModule("com.google.gms:google-services:4.3.10")
            }
        }
    }
}

buildCache {
    local {
        isEnabled = true
        removeUnusedEntriesAfterDays = 3
    }
}

rootProject.name = "Formula One News"
include(":app")
include(":news")
include(":network")
include(":utils")
include(":navigation")
include(":core")
include(":design-system")
include(":navigation-api")
include(":network-api")
include(":championship")
include(":calendar")
include(":login")
include(":image-loader")
include(":firebase")
include(":firebase-api")
include(":core-api")
include(":image-loader-api")
include(":base")
