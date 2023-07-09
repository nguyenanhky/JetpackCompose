package kynv1.it.fsoft.basecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kynv1.it.fsoft.basecompose.ui.theme.BaseComposeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalAppColor provides AppColor(bodyTextColor = Color.Red)) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Logger.lod("MainActivity")
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Logger.lod("MainActivity")

    var bodyTextColor by remember {
        mutableStateOf(Color.Black)
    }

    Column {
        Header(title = "jetpack compose")
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "composition local",
            style = TextStyle(color = LocalAppColor.current.bodyTextColor, fontSize = 18.sp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Body(content = "change color text body", bodyTextColor)
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { bodyTextColor = getColor() }) {
            Text(text = "Change text color")
        }
    }
}

@Composable
fun Header(title: String) {
    Logger.lod("Header")
    Text(text = title, style = TextStyle(color = Color.Black, fontSize = 24.sp))
}

@Composable
fun Body(content: String, bodyTextColor: Color) {
    Logger.lod("Body")
    CompositionLocalProvider(LocalAppColor provides AppColor(bodyTextColor = bodyTextColor)) {
        Column {
            Text(text = content, style = TextStyle(color = LocalAppColor.current.bodyTextColor))
            Spacer(modifier = Modifier.height(12.dp))
            ImageFeature()
        }
    }
}

// LocalAppColor.current ==> AppColor instance
@Composable
fun ImageFeature() {
    Logger.lod("ImageFeature")
    Row {
        Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
        Spacer(modifier = Modifier.width(12.dp))
        Icon(imageVector = Icons.Outlined.Refresh, contentDescription = null)
    }
}

data class AppColor(val bodyTextColor: Color)

//  create CompositionKey
val LocalAppColor = compositionLocalOf {
    AppColor(Color.Black)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BaseComposeTheme {
        MainScreen()
    }
}

fun getColor(): Color {
    val listColor = listOf(Color.Blue, Color.Red, Color.Yellow, Color.Magenta, Color.Green)
    val index = Random.nextInt(0, 4)
    return listColor[index]
}