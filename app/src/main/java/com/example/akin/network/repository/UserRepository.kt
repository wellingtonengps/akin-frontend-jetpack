package com.example.akin.network.repository

import com.example.akin.network.dto.JwtResponseDTO
import com.example.akin.network.dto.UserRequestDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.forms.submitForm
import io.ktor.http.parameters
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class UserRepository {

    suspend fun signIn(user: UserRequestDTO): JwtResponseDTO {
        val httpClient = HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }

        val response: JwtResponseDTO = httpClient.submitForm(
            "http://172.31.224.1:8080/authenticate/login",
            formParameters = parameters {
                append("username", user.username)
                append("password", user.password)
            }).body()

        return response;
    }


}