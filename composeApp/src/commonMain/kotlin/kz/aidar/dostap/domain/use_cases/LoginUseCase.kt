package kz.aidar.dostap.domain.use_cases

import kz.aidar.dostap.data.models.AuthResult
import kz.aidar.dostap.data.util.Error
import kz.aidar.dostap.data.util.Result
import kz.aidar.dostap.domain.repositories.AuthRepository

class LoginUseCase(private val repo: AuthRepository) {

    suspend fun execute(username: String, password: String): Result<AuthResult, Error> {
        return repo.login(username, password)
    }
}