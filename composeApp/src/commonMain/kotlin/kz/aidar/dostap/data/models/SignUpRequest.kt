package kz.aidar.dostap.data.models

data class SignUpRequest(
    val age: Int,
    val avatarLink: String,
    val cityId: Long,
    val description: String,
    val email: String,
    val firstName: String,
    val gender: String,
    val lastName: String,
    val password: String,
    val phoneNumber: String,
    val username: String
)