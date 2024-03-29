package com.example.akin.auth.presentation.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.akin.auth.domain.SignInRequestDTO
import com.example.akin.auth.domain.UserResponseDTO
import com.example.akin.auth.domain.SignInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class SignInViewModel(
    private val signInUserUseCase: SignInUseCase,
) : ViewModel() {

    private val _signUiState = MutableStateFlow(SignInUiState())
    val signUiState: StateFlow<SignInUiState> = _signUiState

    fun updateUiState(signInCredentials: SignInRequestDTO) {
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
                   credentials = signUiState.value.credentials
                )
            } catch (ioe: IOException) {
                val message = ioe.message
                _signUiState.value.message = message.toString()
            }
        }
    }

    private fun validateInput(uiState: SignInRequestDTO = signUiState.value.credentials): Boolean {
        return with(uiState) {
            username.isNotBlank() && password.isNotBlank()
        }
    }
}

data class SignInUiState(
    val user: UserResponseDTO? = null,
    val credentials: SignInRequestDTO = SignInRequestDTO("", ""),
    val isEntryValid: Boolean = true,
    var message: String = ""
)

/*
data class Credentials(
    val username: String = "",
    val password: String = "",
)*/

