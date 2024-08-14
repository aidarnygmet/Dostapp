package kz.aidar.dostap.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(engine: HttpClientEngine): HttpClient{
    return HttpClient(engine){
        install(Logging){
            level = LogLevel.ALL
            logger = object : io.ktor.client.plugins.logging.Logger{
                override fun log(message: String) {
                    println(message)
                }
            }
        }
        install(ContentNegotiation){
            json(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }
//        install(Auth){
//            bearer {
//
//            }
//        }
    }
}