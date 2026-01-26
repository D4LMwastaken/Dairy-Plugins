package dev.frozenmilk

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class FTCLibrariesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val _ = project.repositories.run {
            mavenCentral()
            google()
            maven {
                it.name = "dairyReleases"
                it.url = project.uri("https://repo.dairy.foundation/releases/")
            }
            maven {
                it.name = "bylazarReleases"
                it.url = project.uri("https://mymaven.bylazar.com/releases")
            }
            maven {
                it.name = "brottReleases"
                it.url = project.uri("https://maven.brott.dev/")
            }
        }
        project.extensions.add("ftc", FTC(project))
    }
}