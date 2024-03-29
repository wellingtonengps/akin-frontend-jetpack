package com.example.akin.auth.presentation.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.akin.R
import com.example.akin.auth.presentation.components.TextFieldCustom
import com.example.akin.auth.presentation.signIn.SignInViewModel
import com.example.akin.navigation.NavigationDestination
import com.example.akin.ui.AppViewModelProvider


object SignUpDestination : NavigationDestination {
    override val route = "signUp"
}


@Composable
fun SignUp(
    viewModel: SignUpViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    val signUpUiState by viewModel.signUpUiState.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_image),
            contentDescription = "logo",
            modifier = Modifier.size(100.dp)
        )

        Text(text = "Crie sua conta", fontSize = 32.sp)

        Text(
            text = "Faça sua conta preenchendo\nos campos abaixo",
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(36.dp))

        TextFieldCustom(value = signUpUiState.userInfo.name, onValueChange = {
            viewModel.updateUiState(
                viewModel.signUpUiState.value.userInfo.copy(
                    name = it
                )
            )
        }, label = "Nome")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = signUpUiState.userInfo.lastName, onValueChange = {
            viewModel.updateUiState(
                viewModel.signUpUiState.value.userInfo.copy(
                    lastName = it
                )
            )
        }, label = "Sobrenome")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = signUpUiState.userInfo.gender, onValueChange = {
            viewModel.updateUiState(
                viewModel.signUpUiState.value.userInfo.copy(
                    gender = it
                )
            )
        }, label = "Gênero")

        Spacer(modifier = Modifier.height(18.dp))

        //TextFieldCustom(value = "", onValueChange = {}, label = "Data de Nascimento")

        TextFieldCustom(value = signUpUiState.userInfo.email, onValueChange = {
            viewModel.updateUiState(
                viewModel.signUpUiState.value.userInfo.copy(
                    email = it
                )
            )
        }, label = "E-mail")

        Spacer(modifier = Modifier.height(18.dp))

        //TextFieldCustom(value = "", onValueChange = {}, label = "Confirmar e-mail")

        TextFieldCustom(value = signUpUiState.userInfo.username, onValueChange = {
            viewModel.updateUiState(
                viewModel.signUpUiState.value.userInfo.copy(
                    username = it
                )
            )
        }, label = "Apelido")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = signUpUiState.userInfo.password, onValueChange = {
            viewModel.updateUiState(
                viewModel.signUpUiState.value.userInfo.copy(
                    password = it
                )
            )
        }, label = "Senha", visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(18.dp))

        //TextFieldCustom(value = "", onValueChange = {}, label = "Confirmar senha")

        Spacer(modifier = Modifier.height(63.dp))

        Button(
            onClick = {
                viewModel.fetchSignUp()
            },
            enabled = signUpUiState.isEntryValid,
            modifier = Modifier.size(154.dp, 54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF44E267),
                contentColor = Color(0xFF000000)
            )
        ) {
            Text(text = stringResource(R.string.entrar), fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(56.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:medium_phone")
@Composable
fun SignUpPreview() {
    SignUp()
}