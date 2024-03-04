package com.example.akin.ui.signIn

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.akin.network.dto.UserRequestDTO
import com.example.akin.ui.AppViewModelProvider
import com.example.akin.ui.home.HomeDestination
import com.example.akin.ui.navigation.NavigationDestination
import kotlinx.coroutines.launch


object SignInDestination : NavigationDestination {
    override val route = "signIn"
    const val userInfo = ""
    val routWithArgs = "${route}/{$userInfo}"
}


@Composable
fun SignIn(navController: NavHostController, viewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory)) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    val coroutineScope = rememberCoroutineScope()

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

        TextField(value = username, onValueChange = { value -> username = value },
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
            value = password,
            onValueChange = { value -> password = value },
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
                coroutineScope.launch {
                    viewModel.saveItem()
                }
            },
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