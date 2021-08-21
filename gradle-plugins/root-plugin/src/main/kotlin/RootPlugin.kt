import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.maven

class RootPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        target.extra.properties["GITHUB_REPOSITORY_NAME"] = "template-plugin"

        target.apply(plugin = "com.dipien.component.builder")
        target.apply(plugin = "com.jdroidtools.root")
        target.apply(plugin = "com.dipien.release")
        target.apply(plugin = "dependencies-plugin")

        val propertyResolver = PropertyResolver(target)

        target.allprojects {
            buildscript.apply {
                repositories.apply {
                    mavenCentral()
                    if (propertyResolver.getRequiredBooleanProp("LOCAL_MAVEN_REPO_ENABLED", false)) {
                        maven(url = propertyResolver.getRequiredStringProp("LOCAL_MAVEN_REPO"))
                    }
                    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
                    gradlePluginPortal()
                }
            }

            repositories.apply {
                mavenCentral()
                if (propertyResolver.getRequiredBooleanProp("LOCAL_MAVEN_REPO_ENABLED", false)) {
                    maven(url = propertyResolver.getRequiredStringProp("LOCAL_MAVEN_REPO"))
                }
                maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
            }
        }
    }
}
