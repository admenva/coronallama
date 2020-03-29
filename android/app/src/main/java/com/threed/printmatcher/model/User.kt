package com.threed.printmatcher.model

enum class UserType {
    INSTITUTION, VOLUNTEER
}

sealed class User {
    data class Institution(val name: String, val address: String)
    data class Volunteer(val firstName: String, val lastName: String, val contact: String, val address: String)
}