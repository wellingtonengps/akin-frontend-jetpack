package com.example.akin.auth.presentation.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.akin.auth.presentation.signIn.SignInViewModel
import com.example.akin.navigation.NavigationDestination
import com.example.akin.ui.AppViewModelProvider


object SignUpDestination : NavigationDestination {
    override val route = "signUp"
}



@Composable
fun SignUp(
    viewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "signUp")
    }
}