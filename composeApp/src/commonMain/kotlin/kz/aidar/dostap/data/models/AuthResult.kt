package kz.aidar.dostap.data.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResult(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Long
)