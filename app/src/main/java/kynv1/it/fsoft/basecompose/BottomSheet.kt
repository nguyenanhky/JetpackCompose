package kynv1.it.fsoft.basecompose

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.launch
import kynv1.it.fsoft.basecompose.ui.theme.BaseComposeTheme


@Composable
fun BottomSheet() {

}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DemoModalBottomSheetLayout() {
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    val showBottomSheet: () -> Unit = {
        coroutineScope.launch {
            sheetState.show()
        }
    }
    val hideBottomSheet: () -> Unit = {
        coroutineScope.launch {
            sheetState.hide()
        }
    }

    ModalBottomSheetLayout(sheetState = sheetState, sheetContent = {
        BottomSheetContent {
            hideBottomSheet()
        }
    }) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Top Top") })
            },
            bottomBar = { TopTopBottomAppBar()}
        ) {
            BodyDemo {
                showBottomSheet()
            }
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DemoBottomSheetScaffold() {

    val scaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    val showBottomSheet: () -> Unit = {
        coroutineScope.launch {
            scaffoldState.bottomSheetState.expand()
        }
    }
    val hideBottomSheet: () -> Unit = {
        coroutineScope.launch {
            scaffoldState.bottomSheetState.collapse()
        }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            BottomSheetContent {
                hideBottomSheet()
            }

        }
    ) {
        BodyDemo {
            showBottomSheet()
        }
    }
}

@Composable
fun BodyDemo(modifier: Modifier = Modifier, onShowBottomSheet: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onShowBottomSheet() }) {
            Text(text = "Show Bottom Sheet")
        }
    }
}

@Composable
fun BottomSheetContent(modifier: Modifier = Modifier, hideBottomSheet: () -> Unit) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        Text(text = "Bottom Sheet Content")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { hideBottomSheet() }) {
            Text(text = "Close")
        }
    }
}

@Composable
fun TopTopBottomAppBar() {
    BottomAppBar(
        cutoutShape = CircleShape,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val centerVerticalGuideLine = createGuidelineFromStart(0.5f)
            val (leftMenus, rightMenus) = createRefs()
            Row(modifier = Modifier.constrainAs(leftMenus) {
                start.linkTo(parent.start)
                end.linkTo(centerVerticalGuideLine, margin = 28.dp)
                width = Dimension.fillToConstraints
            }) {
                BottomNavigationItem(
                    selected = true, onClick = { },
                    icon = {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "home")
                    },
                    label = {
                        Text(text = "Home")
                    }
                )
                BottomNavigationItem(
                    selected = true, onClick = { },
                    icon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Friends")
                    },
                    label = {
                        Text(text = "Friends")
                    }
                )
            }
            Row(
                modifier = Modifier.constrainAs(rightMenus) {
                    start.linkTo(centerVerticalGuideLine, margin = 28.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                BottomNavigationItem(selected = true, onClick = { }, icon = {
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
                }, label = {
                    Text(text = "Inbox")
                })
                BottomNavigationItem(selected = true, onClick = { }, icon = {
                    Icon(imageVector = Icons.Default.Face, contentDescription = null)
                }, label = {
                    Text(text = "Profile")
                })


            }
        }
    }
}

@Preview(name = "Bottom sheet", showBackground = true)
@Composable
fun BottomSheetPreview() {
    BaseComposeTheme {
        BottomSheet()
    }
}