package kz.aidar.dostap.domain.repositories

import kz.aidar.dostap.data.models.AuthResult
import kz.aidar.dostap.data.util.Error

interface AuthRepository {
    suspend fun login(username: String, password: String): kz.aidar.dostap.data.util.Result<AuthResult, Error>
    suspend fun signup(username: String, email: String, password: String): kz.aidar.dostap.data.util.Result<AuthResult, Error>
    suspend fun logout(): Result<Unit>
}