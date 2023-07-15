package kynv1.it.fsoft.basecompose.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
fun DemoScaffold() {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    val toggleNavigationDrawer = {
        coroutineScope.launch {
            if (scaffoldState.drawerState.isOpen) {
                scaffoldState.drawerState.close()
            } else {
                scaffoldState.drawerState.open()
            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Top Top") },
                navigationIcon = {
                    IconButton(onClick = { toggleNavigationDrawer() }) {
                        Icon(Icons.Default.Menu, contentDescription = null)

                    }
                },
                actions = {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                        }
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Phone, contentDescription = "Phone")
                    }
                }
            )
        },
        drawerContent = {
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Category")
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Item 1", modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    toggleNavigationDrawer()
                }
                .padding(12.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Item 2")
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Item 3")
            Spacer(modifier = Modifier.height(24.dp))
            Divider()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }, shape = CircleShape) {
                Icon(imageVector = Icons.Default.Add, tint = Color.White, contentDescription = null)

            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape,
                modifier = Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    val centerVerticalGuideLine = createGuidelineFromStart(0.5f)
                    val (leftMenus, rightMenus) = createRefs()
                    Row(
                        modifier = Modifier.constrainAs(leftMenus) {
                            start.linkTo(parent.start)
                            end.linkTo(centerVerticalGuideLine, margin = 28.dp)
                            width = Dimension.fillToConstraints
                        },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        BottomNavigationItem(selected = true, onClick = { }, icon = {
                            Icon(Icons.Default.Home, "")
                        }, label = {
                            Text("Home")
                        })
                        BottomNavigationItem(selected = true, onClick = { }, icon = {
                            Icon(Icons.Default.Person, "")
                        }, label = {
                            Text("Friends")
                        })
                    }

                    Row(
                        modifier = Modifier.constrainAs(rightMenus) {
                            start.linkTo(centerVerticalGuideLine, margin = 28.dp)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }, verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        BottomNavigationItem(selected = true, onClick = { }, icon = {
                            Icon(Icons.Default.AccountBox, "")
                        }, label = {
                            Text("Inbox")
                        })
                        BottomNavigationItem(selected = true, onClick = { }, icon = {
                            Icon(Icons.Default.Face, "")
                        }, label = {
                            Text("Profile")
                        })
                    }

                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), contentAlignment = Alignment.Center
        ) {
            Text(text = "Body")
        }
    }
}

@Preview(name = "demo scaffold")
@Composable
fun DemoScaffoldPreview() {
    BaseComposeTheme {
        DemoScaffold()
    }
}