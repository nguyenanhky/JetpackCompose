package kynv1.it.fsoft.basecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kynv1.it.fsoft.basecompose.ui.theme.BaseComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Logger.lod("login screen start")
        Welcome()
        var email by rememberSaveable {
            mutableStateOf("")
        }
        Email(email){
            email = it
        }

        var pass by rememberSaveable {
            mutableStateOf("")
        }
        PassWord(pass){
            pass = it
        }

        Logger.lod("login screen end")
    }
}


@Composable
fun Email(email:String, onEmailChange:(String)->Unit){
    Logger.lod("email")
    OutlinedTextField(value = email, onValueChange =onEmailChange )
}
@Composable
fun PassWord(password:String, onPasswordChange:(String)->Unit){
    Logger.lod("password")
    OutlinedTextField(value = password, onValueChange = onPasswordChange)
}
@Composable
fun Welcome() {
    Logger.lod("welcome start")
    Text(text = "Login to your account")
    Logger.lod("welcome end")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BaseComposeTheme {
        LoginScreen()
    }
}
