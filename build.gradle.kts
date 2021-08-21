version = "1.0.0"

buildscript {
	repositories {
		mavenCentral()
		maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
		gradlePluginPortal()
	}
	dependencies {
		classpath("com.dipien:root-plugin:1.0.0")
	}
}

apply(plugin = "root-plugin")

