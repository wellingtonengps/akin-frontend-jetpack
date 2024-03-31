package com.example.akin.auth.data

import com.example.akin.auth.domain.SignInRequestDTO
import com.example.akin.auth.domain.SignUpRequestDTO
import com.example.akin.auth.domain.UserResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class AuthRepository {

    private val baseURL : String = "http://172.26.176.1:8080"

    private val httpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun signIn(user: SignInRequestDTO): UserResponseDTO {
        val response: UserResponseDTO = httpClient.post(
            "${baseURL}/authenticate/login") {
            contentType(ContentType.Application.Json)
            setBody(user)
        }.body()

        return response;
    }

    suspend fun signUp(user: SignUpRequestDTO) : UserResponseDTO {
        val response: UserResponseDTO = httpClient.post(
            //todo: alterar esse endpoint futuramente
            "${baseURL}/user/create"
        ){
            contentType(ContentType.Application.Json)
            setBody(user)
        }.body()

        return response
    }
}


