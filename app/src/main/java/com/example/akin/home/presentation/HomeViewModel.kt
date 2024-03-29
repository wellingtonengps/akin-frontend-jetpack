package com.example.akin.home.presentation

import androidx.lifecycle.ViewModel
import com.example.akin.auth.presentation.signIn.SignInUiState
import com.example.akin.home.domain.HomeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val homeUseCase: HomeUseCase,
) : ViewModel() {
    private val _signUiState = MutableStateFlow(SignInUiState())
    val signUiState: StateFlow<SignInUiState> = _signUiState


}