package kynv1.it.fsoft.basecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    /**
     * Box
     */
//    DemoBoxCompose()
    /**
     * Row
     */

    DemoRow()
}

@Composable
fun DemoBoxCompose() {
    Box(contentAlignment = Alignment.Center) {
        BoxItem(color = Color.Red, size = 200.dp)
        BoxItem(color = Color.Blue, size = 150.dp)
        BoxItem(color = Color.Yellow)
    }
}

@Composable
fun DemoRow() {
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Black),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Yellow)
        }
    }
}

@Composable
fun BoxItem(modifier: Modifier = Modifier, color: Color, size: Dp = 100.dp) {
    Box(
        modifier = Modifier
            .size(size)
            .background(color)
    )
}

@Composable
fun CommonSpace() {
    Spacer(modifier = Modifier.height(24.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BaseComposeTheme {
        HomeScreen()
    }
}