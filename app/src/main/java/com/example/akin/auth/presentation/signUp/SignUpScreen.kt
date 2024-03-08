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
    //viewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        Image(
            painter = painterResource(id = R.drawable.logo_image),
            contentDescription = "logo",
        )

        Text(text = "Crie sua conta", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Faça sua conta preenchendo\nos campos abaixo",
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(36.dp))

        TextFieldCustom(value = "", onValueChange = {}, label = "Nome")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = "", onValueChange = {}, label = "Sobrenome")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = "", onValueChange = {}, label = "Gênero")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = "", onValueChange = {}, label = "Data de Nascimento")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = "", onValueChange = {}, label = "E-mail")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = "", onValueChange = {}, label = "Confirmar e-mail")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = "", onValueChange = {}, label = "Senha")

        Spacer(modifier = Modifier.height(18.dp))

        TextFieldCustom(value = "", onValueChange = {}, label = "Confirmar senha")

        Spacer(modifier = Modifier.height(63.dp))

        Button(
            onClick = {

            },
            //enabled = signInUiState.isEntryValid,
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