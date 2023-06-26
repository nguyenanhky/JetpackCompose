package kynv1.it.fsoft.basecompose.ui.customer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AddressDetailScreen(addressId: String?, saveAddressAndBack: (String?) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        var savableAddressId by rememberSaveable {
            mutableStateOf(addressId)
        }

        if (addressId.isNullOrEmpty()) {
            Text(text = "Add new Address")
        } else {
            Text(text = "Edit Address with id: $addressId")
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = savableAddressId ?: "", onValueChange = {
            savableAddressId = it
        }, enabled = (addressId.isNullOrEmpty()))
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            saveAddressAndBack(savableAddressId)
        }) {
            Text("Save")
        }
    }

}

@Composable
@Preview(name = "Address Detail Screen", showBackground = true)
fun AddressDetailScreenPreview() {
    AddressDetailScreen(addressId = "", saveAddressAndBack = { address -> })
}