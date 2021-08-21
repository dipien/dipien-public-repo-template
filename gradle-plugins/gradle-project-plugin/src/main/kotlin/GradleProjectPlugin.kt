import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class GradleProjectPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply(plugin = "com.jdroidtools.gradle.plugin")
    }
}
