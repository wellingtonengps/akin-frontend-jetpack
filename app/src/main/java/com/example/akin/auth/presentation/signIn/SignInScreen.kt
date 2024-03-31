package com.example.akin.auth.presentation.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.akin.R
import com.example.akin.auth.presentation.components.ButtonCustom
import com.example.akin.auth.presentation.components.ButtonSize
import com.example.akin.auth.presentation.components.DividerWithText
import com.example.akin.auth.presentation.components.OutLineButtonCustom
import com.example.akin.auth.presentation.components.TextFieldCustom
import com.example.akin.auth.presentation.signUp.SignUpDestination
import com.example.akin.ui.AppViewModelProvider
import com.example.akin.navigation.NavigationDestination


object SignInDestination : NavigationDestination {
    override val route = "signIn"
    const val userInfo = ""
    val routWithArgs = "$route/{$userInfo}"
}

@Composable
fun SignIn(
    navController: NavHostController,
    //userViewModel: UserViewModel = viewModel(factory = AppViewModelProvider.Factory),
    viewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val signInUiState by viewModel.signUiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_image),
            contentDescription = "logo",
            modifier = Modifier.size(100.dp)       )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = stringResource(R.string.title_login_page), fontSize = 28.sp)
        Text(
            text = stringResource(R.string.text_login_page),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

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

        Spacer(modifier = Modifier.height(6.dp))

        Text("Esqueceu a senha?", textAlign = TextAlign.End, modifier = Modifier.width(300.dp))

        Spacer(modifier = Modifier.height(32.dp))

        ButtonCustom(
            onClick = { viewModel.fetchSign() },
            label = "Entrar",
            backgroundColor = Color(0xFF44E267)
        )

        /*
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
        }*/

        Spacer(modifier = Modifier.height(16.dp))

        DividerWithText(text = "ou")

        Spacer(modifier = Modifier.height(16.dp))

        Row() {

            ButtonCustom(
                onClick = { viewModel.fetchSign() },
                label = "Google",
                buttonSize = ButtonSize.Small,
                imageVector = ImageVector.vectorResource(R.drawable.google_icon),
                backgroundColor = Color(0xFFEFEFEF)
            )
            
            Spacer(modifier = Modifier.width(20.dp))

            ButtonCustom(
                onClick = { viewModel.fetchSign() },
                label = "Facebook",
                buttonSize = ButtonSize.Small,
                imageVector = ImageVector.vectorResource(R.drawable.facebook_icon),
                backgroundColor = Color(0xFFEFEFEF)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        DividerWithText(text = "Você não tem conta?")

        Spacer(modifier = Modifier.height(16.dp))

        /*
        ButtonCustom(
            onClick = { navController.navigate(SignUpDestination.route) },
            label = "Registrar",
            buttonSize = ButtonSize.Large,
            //imageVector = ImageVector.vectorResource(R.drawable.facebook_icon),
            backgroundColor = Color(0xFF850DFE)
        )*/

        OutLineButtonCustom(onClick = { navController.navigate(SignUpDestination.route)  }, label = "Registrar", borderColor =  Color(0xFF850DFE))
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:medium_phone")
@Composable
fun SignUpPreview() {
    SignIn(rememberNavController())
}