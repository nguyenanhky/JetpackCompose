package kynv1.it.fsoft.basecompose.ui.customer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomerInfoScreen(onClickBack: () -> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        Text(text = "Customer Information")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {

        }) {
            Text("Back")
        }
    }
}
@Composable
@Preview(name = "Customer Info Screen", showBackground = true)
fun CustomerInfoScreenPreview(){
    CustomerInfoScreen(onClickBack = {})
}