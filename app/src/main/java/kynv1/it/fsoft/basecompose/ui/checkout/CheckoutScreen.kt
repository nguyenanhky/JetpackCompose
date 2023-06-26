package kynv1.it.fsoft.basecompose.ui.checkout

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CheckoutScreen(
    cartId: String, customerId: String,
    placeOrderAction: () -> Unit,
    backTrack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text("Processing cart with id: $cartId for customer with id: $customerId")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            placeOrderAction()
        }) {
            Text(text = "Place order")
        }
        Button(onClick = { backTrack() }) {
            Text(text = "back to previous")
        }
    }
}

@Composable
@Preview(name = "Checkout screen", showBackground = true)
fun CheckoutScreenPreview() {
    CheckoutScreen(cartId = "", customerId = "", backTrack = {}, placeOrderAction = {})
}