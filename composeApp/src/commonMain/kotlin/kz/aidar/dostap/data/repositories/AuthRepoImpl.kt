package kz.aidar.dostap.data.repositories

import kz.aidar.dostap.data.models.AuthResult
import kz.aidar.dostap.data.networking.AuthClient
import kz.aidar.dostap.data.util.Error
import kz.aidar.dostap.domain.repositories.AuthRepository

class AuthRepoImpl(private val client: AuthClient): AuthRepository {
    override suspend fun login(
        username: String,
        password: String
    ): kz.aidar.dostap.data.util.Result<AuthResult, Error> {
        return client.login(username, password)
    }

    override suspend fun signup(
        username: String,
        email: String,
        password: String
    ): kz.aidar.dostap.data.util.Result<AuthResult, Error> {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Result<Unit> {
        TODO("Not yet implemented")
    }
}