package dev.frozenmilk.libs

import dev.frozenmilk.FTC
import dev.frozenmilk.easyautolibraries.EasyAutoDependency
import dev.frozenmilk.easyautolibraries.EasyAutoScope

@Suppress("unused")
class PsiLynx(ftc: FTC) : EasyAutoScope<PsiLynx>(ftc) {

    var version = "0.1.0-beta2"

    private val psikit = dependency { name ->
        EasyAutoDependency(
            group = "org.psilynx.psikit",
            artifact = name,
            defaultVersion = { version }
        )
    }

    val core by psikit
    val ftc by psikit
}