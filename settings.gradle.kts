plugins {
    id("com.gradle.enterprise").version("3.6.3")
}

if (System.getenv("CI") == "true") {
    buildCache {
        local {
            directory = File(System.getProperty("user.home"), "/gradle-build-cache")
        }
    }
}

includeBuild("gradle-plugins/dependencies-plugin")
includeBuild("gradle-plugins/root-plugin")
includeBuild("gradle-plugins/gradle-project-plugin")
include(":template-plugin")
