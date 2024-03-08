package com.example.akin.auth.presentation.signIn

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.akin.auth.domain.UserViewModel
import com.example.akin.auth.presentation.components.TextFieldCustom
import com.example.akin.ui.AppViewModelProvider
import com.example.akin.ui.home.HomeDestination
import com.example.akin.navigation.NavigationDestination


object SignInDestination : NavigationDestination {
    override val route = "signIn"
    const val userInfo = ""
    val routWithArgs = "$route/{$userInfo}"
}


@Composable
fun SignIn(
    navController: NavHostController,
    userViewModel: UserViewModel = viewModel(factory = AppViewModelProvider.Factory),
    viewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    val userInfo by userViewModel.userInfo.collectAsState()

    val signInUiState by viewModel.signUiState.collectAsState()
    signInUiState.user?.let { Log.i("teste", it.username) }


    LaunchedEffect(userInfo) {
        if (userInfo != null) {
            navController.navigate(HomeDestination.route)
        }
    }

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

        TextFieldCustom(
            value = signInUiState.credentials.username,
            onValueChange = {
                viewModel.updateUiState(
                    viewModel.signUiState.value.credentials.copy(username = it)
                )
            },
            label = "Usuário",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "ícone usuário"
                )
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextFieldCustom(
            value = signInUiState.credentials.password,
            onValueChange = {
                viewModel.updateUiState(
                    viewModel.signUiState.value.credentials.copy(password = it)
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            label = "Senha",
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
            enabled = signInUiState.isEntryValid,
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