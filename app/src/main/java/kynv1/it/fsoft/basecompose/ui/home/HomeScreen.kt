package kynv1.it.fsoft.basecompose.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    openCategoryAction: () -> Unit,
    openMyAccountScreen: () -> Unit,
    editCustomerInfo: () -> Unit,
    openAddressBook: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { openCategoryAction() }) {
            Text("Open Category")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            openMyAccountScreen()
        }) {
            Text(text = "Open MyAccount")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            editCustomerInfo()
        }) {
            Text(text = "Edit customer information")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            openAddressBook()
        }) {
            Text(text = "AddressBook")
        }
    }
}

@Composable
@Preview(name = "Home screen", showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(
        openCategoryAction = { /*TODO*/ },
        openMyAccountScreen = { /*TODO*/ },
        editCustomerInfo = {}
    ) {

    }
}