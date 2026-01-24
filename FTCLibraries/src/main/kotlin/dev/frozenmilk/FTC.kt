package dev.frozenmilk

import dev.frozenmilk.easyautolibraries.EasyAutoScopeRoot
import dev.frozenmilk.easyautolibraries.brightBlue
import dev.frozenmilk.libs.ACMERobotics
import dev.frozenmilk.libs.Dairy
import dev.frozenmilk.libs.FateWeaver
import dev.frozenmilk.libs.FtControl
import dev.frozenmilk.libs.Next
import dev.frozenmilk.libs.Pedro
import dev.frozenmilk.libs.PsiLynx
import dev.frozenmilk.libs.SDK
import dev.frozenmilk.libs.Solvers
import org.gradle.api.Project
import org.gradle.api.logging.LogLevel
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

@Suppress("unused")
class FTC(project: Project) : EasyAutoScopeRoot<FTC>(project, LogLevel.LIFECYCLE) {
    fun kotlin() {
        val isAndroid = project.plugins.hasPlugin("com.android.base")
        if (isAndroid) {
            project.logger.log(logLevel, brightBlue("kotlin-android"))
            project.plugins.apply("org.jetbrains.kotlin.android")
            with(project.extensions.getByType(KotlinAndroidProjectExtension::class.java)) {
                jvmToolchain { it.languageVersion.set(JavaLanguageVersion.of(8)) }
                compilerOptions {
                    freeCompilerArgs.add("-Xjvm-default=all")
                }
            }
        } else {
            project.logger.log(logLevel, brightBlue("kotlin-jvm"))
            project.plugins.apply("org.jetbrains.kotlin.jvm")
            with(project.extensions.getByType(KotlinJvmProjectExtension::class.java)) {
                jvmToolchain { it.languageVersion.set(JavaLanguageVersion.of(8)) }
                compilerOptions {
                    freeCompilerArgs.add("-Xjvm-default=all")
                }
            }
        }
    }

    val sdk = SDK(this)

    val acmerobotics = ACMERobotics(this)

    val ftControl = FtControl(this)

    // note: needs to come after acmerobotics' dashboard
    // note: needs to come after ftControl
    val dairy = Dairy(this)

    val next = Next(this)

    val pedro = Pedro(this)

    val solvers = Solvers(this)

    val psiLynx = PsiLynx(this)

    val fateWeaver = FateWeaver(this)
}