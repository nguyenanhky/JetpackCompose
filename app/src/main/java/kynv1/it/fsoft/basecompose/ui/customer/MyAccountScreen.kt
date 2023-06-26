package kynv1.it.fsoft.basecompose.ui.customer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun MyAccountScreen(navController: NavController, openAddressScreen: (String?) -> Unit) {
    var addressId by rememberSaveable {
        mutableStateOf("")
    }

    val newAddressId =
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>("new_address_id")
            ?.observeAsState()
    newAddressId?.value?.let {
        addressId = it
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text("My Account ")
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            openAddressScreen(null)
        }) {
            Text("Add address")
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = addressId, onValueChange = {
            addressId = it
        })
        Spacer(modifier = Modifier.height(6.dp))
        Button(onClick = {
            openAddressScreen(addressId)
        }) {
            Text("Edit Address")
        }


    }

}

@Composable
@Preview(name = "MyAccountScreen", showBackground = true)
fun MyAccountScreenPreview() {
    MyAccountScreen(navController = rememberNavController(), openAddressScreen = { addressId ->
        // Xử lý logic khi nhấn nút "Thêm địa chỉ" hoặc "Chỉnh sửa địa chỉ"
        // addressId: ID của địa chỉ được chọn (nếu có)
    })
}