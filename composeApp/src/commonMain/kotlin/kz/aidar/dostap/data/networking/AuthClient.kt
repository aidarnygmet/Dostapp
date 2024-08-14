package kz.aidar.dostap.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.util.InternalAPI
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import kz.aidar.dostap.data.models.AuthResult
import kz.aidar.dostap.data.models.LoginRequest
import kz.aidar.dostap.data.util.NetworkError
import kz.aidar.dostap.data.util.Result

class AuthClient(private val client: HttpClient) {
    @OptIn(InternalAPI::class)
    suspend fun login(username: String, password: String): Result<AuthResult, NetworkError>{
        val response = try {
            client.post(urlString = ""){
                body = LoginRequest(username, password)
            }
        } catch (e: UnresolvedAddressException){
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException){
            return Result.Error(NetworkError.SERIALIZATION)
        }
        return when(response.status.value){
            in 200..299 -> Result.Success(response.body<AuthResult>())
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}