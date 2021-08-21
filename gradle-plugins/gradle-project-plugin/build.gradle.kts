plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

buildscript {
    repositories {
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.dipien:dependencies-plugin:1.0.0")
    }
}

allprojects {
    repositories {
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

dependencies {
    implementation("com.dipien:dependencies-plugin:1.0.0")
    implementation(BuildLibs.JDROID_GRADLE_PROJECT_PLUGIN)
}

group = "com.dipien"
version = "1.0.0"

apply(plugin = "dependencies-plugin")

gradlePlugin {
    plugins.register("gradle-project-plugin") {
        id = "gradle-project-plugin"
        implementationClass = "GradleProjectPlugin"
    }
}
