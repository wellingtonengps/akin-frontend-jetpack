package com.example.akin.auth.presentation.signIn

import android.util.Log
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
import com.example.akin.auth.domain.toUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class SignInViewModel(
    private val signInUserUseCase: SignInUserUseCase
) : ViewModel() {

    private val _signUiState = MutableStateFlow(SignInUiState())
    val signUiState: StateFlow<SignInUiState> = _signUiState

    fun updateUiState(signInCredentials: Credentials) {
        _signUiState.value = SignInUiState(
            credentials = signInCredentials,
            isEntryValid = validateInput(signInCredentials),
        );
    }


    private fun updateUser(user: UserResponseDTO) {
        _signUiState.value = SignInUiState(
            user = user
        )
    }

    fun fetchSign() {
        viewModelScope.launch {
            try {
                val user =  signInUserUseCase(
                   "username4", "password4"
                )
                updateUser(user)
            } catch (ioe: IOException) {
                val message = ioe.message
                _signUiState.value.message = message.toString()
            }
        }
    }

    private fun validateInput(uiState: Credentials = signUiState.value.credentials): Boolean {
        return with(uiState) {
            username.isNotBlank() && password.isNotBlank()
        }
    }
}

data class SignInUiState(
    val user: UserResponseDTO? = null,
    val credentials: Credentials = Credentials(),
    val isEntryValid: Boolean = true,
    var message: String = ""
)

data class Credentials(
    val username: String = "",
    val password: String = "",
)

