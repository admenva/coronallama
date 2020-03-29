package com.threed.printmatcher.model

enum class UserType {
    INSTITUTION, VOLUNTEER
}

sealed class User {
    data class Institution(val name: String, val address: String)
    data class Volunteer(val name: String, val lastName: String)
}