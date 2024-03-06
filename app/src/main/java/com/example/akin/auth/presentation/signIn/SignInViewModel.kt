package com.example.akin.auth.presentation.signIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.akin.auth.data.User
import com.example.akin.auth.data.UserRepository
import com.example.akin.auth.domain.UserRequestDTO
import com.example.akin.auth.domain.UserResponseDTO
import com.example.akin.auth.data.AuthRepository
import com.example.akin.auth.domain.SignInUserUseCase
import kotlinx.coroutines.launch
import java.io.IOException

class SignInViewModel(
    private val signInUserUseCase: SignInUserUseCase

) : ViewModel() {

    var signUiState by mutableStateOf(SignInUiState())
        private set

    fun updateUiState(signInCredentials: Credentials) {
        signUiState = SignInUiState(
            credentials = signInCredentials,
            isEntryValid = validateInput(signInCredentials)
        );
    }

    fun fetchSign() {
        viewModelScope.launch {
            try {
                signInUserUseCase(signUiState.credentials.username, signUiState.credentials.password)
            } catch (ioe: IOException) {
                val messages = ioe.message
                signUiState = signUiState.copy(message = messages.toString())
            }
        }
    }

    private fun validateInput(uiState: Credentials = signUiState.credentials): Boolean {
        return with(uiState) {
            username.isNotBlank() && password.isNotBlank()
        }
    }
}

data class SignInUiState(
    val credentials: Credentials = Credentials(),
    val isEntryValid: Boolean = false,
    val message: String = ""
)

data class Credentials(
    val username: String = "",
    val password: String = "",
)

