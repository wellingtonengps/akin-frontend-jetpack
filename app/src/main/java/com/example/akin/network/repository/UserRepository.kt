package com.example.akin.network.repository

import com.example.akin.data.User
import com.example.akin.network.dto.JwtResponseDTO
import com.example.akin.network.dto.UserRequestDTO
import com.example.akin.network.dto.UserResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.parameters
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class UserRepository {

    suspend fun signIn(user: UserRequestDTO): UserResponseDTO {
        val httpClient = HttpClient(Android) {
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

        val response: UserResponseDTO = httpClient.post(
            "http://172.31.16.1:8080/authenticate/login") {
            contentType(ContentType.Application.Json)
            setBody(UserRequestDTO(user.username, user.password))
        }.body()

        return response;
    }


}


