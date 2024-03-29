package com.example.akin.auth.presentation.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.akin.auth.domain.SignInRequestDTO
import com.example.akin.auth.domain.SignInUseCase
import com.example.akin.auth.domain.SignUpRequestDTO
import com.example.akin.auth.domain.SignUpUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _signUpUiState = MutableStateFlow(SignUpUiState())
    val signUpUiState: StateFlow<SignUpUiState> = _signUpUiState

    fun updateUiState(signUpUserInfo: SignUpRequestDTO) {
        _signUpUiState.value = SignUpUiState(
            userInfo = signUpUserInfo,
            isEntryValid = validateInput(signUpUserInfo),
        );
    }

    fun fetchSignUp() {
        viewModelScope.launch {
            try {
                val user = signUpUseCase(
                    user = signUpUiState.value.userInfo
                )
                signInUseCase(SignInRequestDTO(signUpUiState.value.userInfo.username, signUpUiState.value.userInfo.password))
            } catch (ioe: IOException) {
                val message = ioe.message
                _signUpUiState.value.message = message.toString()
            }
        }
    }

    private fun validateInput(uiState: SignUpRequestDTO = signUpUiState.value.userInfo): Boolean {
        return with(uiState) {
            name.isNotBlank() && lastName.isNotBlank() && gender.isNotBlank() && email.isNotBlank() && password.isNotBlank() && username.isNotBlank()
        }
    }
}

data class SignUpUiState(
    val userInfo: SignUpRequestDTO = SignUpRequestDTO("", "", "", "", "", "", ""),
    val isEntryValid: Boolean = false,
    var message: String = ""
)

