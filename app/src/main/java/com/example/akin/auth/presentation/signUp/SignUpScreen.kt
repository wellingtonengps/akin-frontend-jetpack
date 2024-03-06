package com.example.akin.auth.presentation.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.akin.ui.navigation.NavigationDestination


object SignUpDestination : NavigationDestination {
    override val route = "signUp"
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "signUp")
    }
}