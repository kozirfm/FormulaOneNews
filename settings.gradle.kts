pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.6.10")
            }
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.2.1")
            }
            if (requested.id.id.startsWith("androidx.navigation")) {
                useModule("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
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
include(":core")
include(":news")
include(":network")
include(":utils")
include(":navigation")
include(":design-system")
include(":navigation-api")
include(":network-api")
include(":championship")
include(":calendar")
include(":login")
include(":image-loader")
include(":firebase")
include(":firebase-api")
include(":image-loader-api")
include(":persistent-storage")
include(":persistent-storage-api")
include(":news-detail")
include(":news-api")
include(":calendar-api")
