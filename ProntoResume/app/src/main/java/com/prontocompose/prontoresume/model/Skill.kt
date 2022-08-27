package com.prontocompose.prontoresume.model

data class Skill(val name: String, val rating: Int = 5)

fun sampleLanguages() = listOf(
    Skill("Java",  5),
    Skill("Kotlin",  5),
    Skill("C#",  3),
    Skill("Java Script",  4),
)
