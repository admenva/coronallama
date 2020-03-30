package com.threed.printmatcher.model

enum class UserType {
    INSTITUTION, VOLUNTEER
}

sealed class User {
    data class Institution(
        val id: String,
        val name: String,
        val email: String,
        val address: String
    ) : User()

    data class Volunteer(
        val name: String,
        val description: String,
        val email: String,
        val address: String
    ) : User()
}
