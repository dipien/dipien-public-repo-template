plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

group = "com.dipien"
version = "1.0.0"

gradlePlugin {
    plugins.register("dependencies-plugin") {
        id = "dependencies-plugin"
        implementationClass = "DependenciesPlugin"
    }
}
