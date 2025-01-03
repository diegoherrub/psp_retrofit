package com.psp.model

import kotlinx.serialization.Serializable

@Serializable
enum class Course {
    FIRST, SECOND, THIRD, FOURTH, FIFTH,
    DAM1, DAM2, DAW1, DAW2, DAR2
}

@Serializable
enum class Subject {
    ADD, PMDM, PSP, DDI, SGE, EIE,
    LMSGI, SI, BBDD, ED, PRG, FOL
}

@Serializable
data class Student(
    var id: Int = 0,
    val name: String,
    val email: String,
    val course: Course,
    val subjects: List<Subject>
)