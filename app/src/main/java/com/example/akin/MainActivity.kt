package com.example.akin


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.akin.network.dto.JwtResponseDTO
import com.example.akin.network.dto.UserRequestDTO
import com.example.akin.network.repository.UserRepository
import com.example.akin.ui.theme.AkinTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AkinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val userRepository = UserRepository()
                    val scope = rememberCoroutineScope()
                    var responseTokens: JwtResponseDTO? = null

                    NavHost(navController = navController, startDestination = "main/{UserInfo}") {
                        composable("main/{UserInfo}") { backStackEntry ->
                            backStackEntry.arguments?.let { tokens ->
                                Main(navController = navController, responseToken = tokens)
                            } ?: LaunchedEffect(null) {
                                navController.navigate("signIn")
                            }

                        }
                        composable("firstPage") {
                            FirstPage(navController)
                        }
                        composable("signIn") {
                            SignIn(navController, onSignIn = {
                                scope.launch {
                                    responseTokens = userRepository.signIn(it)
                                    navController.navigate(
                                        "main/{${
                                            responseTokens
                                        }}"
                                    )
                                    Log.i("JwtResponse", "onCreate: $responseTokens")
                                }
                            })
                        }
                        composable("signUp") {
                            SignUp()
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun FirstPage(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_image),
            contentDescription = "logo",
        )

        Spacer(modifier = Modifier.height(131.dp))

        Button(
            onClick = { navController.navigate("signIn") },
            modifier = Modifier.size(287.dp, 54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF44E267),
                contentColor = Color(0xFF000000)
            )
        ) {
            Text(text = stringResource(R.string.entrar), fontSize = 16.sp)
        }


        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("signUp") },
            modifier = Modifier.size(287.dp, 54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF860DFF),
                contentColor = Color(0xFFF5F5F5)
            )
        ) {
            Text(text = stringResource(R.string.criar_conta), fontSize = 16.sp)
        }

    }
}

@Composable
fun SignIn(navController: NavHostController, onSignIn: (UserRequestDTO) -> Unit) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
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
                onSignIn(
                    UserRequestDTO(username, password)
                )
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

@Composable
fun Main(navController: NavHostController, responseToken: Bundle) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "accessToken: ${responseToken.getString("accessToken")}")
        Text(text = "refreshToken: ${responseToken.getString("refreshToken")}")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.green_100), colorResource(
                            id = R.color.purple_100
                        )
                    )
                )
            ),
        Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_splash),
            contentDescription = "logo",
        )
    }
}

