package kynv1.it.fsoft.basecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
fun HomeScreen(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current;
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

}

@Composable
fun Ingredient(
    @DrawableRes icon: Int,
    value: Int,
    unit: String?,
    name: String,
    modifier: Modifier = Modifier
) {
    val borderColor = Color(0xFFFEF9E4)
    val backgroundColor = Color(0xFFFBE897).copy(0.7f)

    ConstraintLayout(
        modifier = modifier
            .background(color = backgroundColor, shape = CircleShape)
            .border(BorderStroke(1.dp, color = borderColor))
    ) {
        val horizontalGuideLine = createGuidelineFromTop(0.5f)
        val imgIcon = createRef()
        Image(
            painter = painterResource(id = icon),
            contentDescription = "lemon",
            modifier = Modifier.constrainAs(imgIcon) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(horizontalGuideLine)
                height = Dimension.fillToConstraints
            },
            contentScale = ContentScale.FillHeight
        )

        val verticalGuideLine = createGuidelineFromStart(0.5f)
        val (tvValue, tvUnit, tvName) = createRefs()
        val valueTextColor = Color(0xFFFB7D8A)
        Text(text = value.toString(),
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                lineHeight = 14.sp,
                color = valueTextColor
            ),
            modifier = Modifier.constrainAs(tvValue) {
                top.linkTo(horizontalGuideLine, margin = 2.dp)
                end.linkTo(verticalGuideLine, margin = 2.dp)
            }
        )
        unit?.let {
            Text(text = unit,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    color = valueTextColor,
                ),
                modifier = Modifier.constrainAs(tvUnit) {
                    top.linkTo(tvValue.bottom, margin = 2.dp)
                    end.linkTo(tvValue.end)
                }
            )
        }

        val bottomBarrier = createBottomBarrier(tvValue, tvUnit)
        val nameTextColor = Color(0xFF1E2742)
        Text(
            text = name,
            style = TextStyle(
                color = nameTextColor,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 14.sp,
            ),
            modifier = modifier.constrainAs(tvName) {
                start.linkTo(verticalGuideLine)
                bottom.linkTo(bottomBarrier)
            },
            maxLines = 2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientPreview() {
    Row {
        Ingredient(
            icon = R.drawable.lemon,
            value = 30,
            unit = "ml",
            name = "Lemon Juice",
            modifier = Modifier.size(150.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BaseComposeTheme {
        HomeScreen()
    }
}

/**
 * https://www.figma.com/file/iUKb1HjSS7NrhbGdxjCxb3/Make-Your-Own-Drink-App-(Community)?node-id=2-2&t=1hWQZTr1fmNcpY2c-0
 */