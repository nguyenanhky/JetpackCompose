package kynv1.it.fsoft.basecompose.ui.cartlog.category

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
fun CategoryScreen(openProductDetail:(String)->Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        Text(text = "Category Screen")
        Spacer(modifier = Modifier.height(24.dp))

        var productId by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(value = productId, onValueChange = {
            productId = it
        }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { openProductDetail(productId) }) {
            Text("Open Product Detail")
        }
    }
}
@Composable
@Preview(name = "Category screen", showBackground = true)
fun CategoryScreenPreview(){
    CategoryScreen(openProductDetail = {})
}