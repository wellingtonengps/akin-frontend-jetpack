package com.example.akin.network.repository

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class UserRepository() {

    suspend fun signIn(username: String, password: String): HttpResponse {
        //todo: verificar CIO, nova implementação.
        val httpClient = HttpClient(Android) {
            //nota: chamada install server para instalar coisa no httpClient
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
        return httpClient.post("http://localhost:8080/authenticate/login") {
            setBody(MultiPartFormDataContent(parts = formData {
                append("username", "username1")
                append("password", "password1" )
            }))
        }
    }
}