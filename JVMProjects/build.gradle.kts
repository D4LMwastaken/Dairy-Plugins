repositories {
    mavenCentral()
    google()
    maven("https://repo.dairy.foundation/releases")
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.0"
    id("java-gradle-plugin")
    id("dev.frozenmilk.publish")
}

group = "dev.frozenmilk"

kotlin {
    jvmToolchain(17)
    compilerOptions {
        freeCompilerArgs.add("-Xjvm-default=all")
    }
    coreLibrariesVersion = "1.9.24"
}

dairyPublishing {
    // git directory is in the parent
    gitDir = file("..")
}

dependencies {
    implementation("dev.frozenmilk:FTCLibraries:${dairyPublishing.version}")
}

gradlePlugin {
    plugins {
        create("Library") {
            id = "dev.frozenmilk.jvm-library"
            implementationClass = "dev.frozenmilk.JVMLibraryPlugin"
        }
    }
}
