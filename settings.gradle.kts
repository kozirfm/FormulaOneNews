pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")){
                useModule("com.android.tools.build:gradle:7.0.2")
            }
            if (requested.id.id.startsWith("org.jetbrains.kotlin")){
                useVersion("1.5.30")
            }
        }
    }
}
rootProject.name = "Formula One News"
include(":app")
include(":news")
include(":network")
include(":utils")
include(":navigation")
include(":core")
include(":news-api")
include(":design-system")
include(":navigation-api")
include(":navigation-graph")
include(":network-api")
include(":championship-api")
include(":championship")
