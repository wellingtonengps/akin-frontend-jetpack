package com.example.akin.auth.presentation.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.akin.R
import com.example.akin.ui.AppViewModelProvider
import com.example.akin.ui.navigation.NavigationDestination


object SignInDestination : NavigationDestination {
    override val route = "signIn"
    const val userInfo = ""
    val routWithArgs = "$route/{$userInfo}"
}


@Composable
fun SignIn(
    navController: NavHostController,
    viewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_image),
            contentDescription = "logo",
        )
        Text(stringResource(R.string.title_login_page), fontSize = 32.sp)
        Text(
            stringResource(R.string.text_login_page),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(41.dp))

        TextField(value = viewModel.signUiState.credentials.username,
            onValueChange = { viewModel.updateUiState(viewModel.signUiState.credentials.copy(username = it)) },
            modifier = Modifier
                .height(56.dp)
                .width(300.dp),
            shape = RoundedCornerShape(12.dp),
            label = {
                Text(text = "Usuário")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "ícone usuário"
                )
            })

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = viewModel.signUiState.credentials.password,
            onValueChange = { viewModel.updateUiState(viewModel.signUiState.credentials.copy(password = it)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .height(56.dp)
                .width(300.dp),
            shape = RoundedCornerShape(12.dp),
            label = {
                Text(text = "Senha")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "ícone senha"
                )
            }
        )

        Spacer(modifier = Modifier.height(217.dp))

        Button(
            onClick = {
                viewModel.fetchSign()
            },
            enabled = viewModel.signUiState.isEntryValid,
            modifier = Modifier.size(154.dp, 54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF44E267),
                contentColor = Color(0xFF000000)
            )
        ) {
            Text(text = stringResource(R.string.entrar), fontSize = 16.sp)
        }

    }
}