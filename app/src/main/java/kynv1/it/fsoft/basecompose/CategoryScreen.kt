package kynv1.it.fsoft.basecompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kynv1.it.fsoft.basecompose.ui.theme.BaseComposeTheme


@Composable
fun CategoryScreen(modifier: Modifier = Modifier){

}

@Composable
@Preview(name = "Category Screen Preview", showBackground =  true, showSystemUi = true)
fun CategoryScreenPreview(){
    BaseComposeTheme {
        CategoryScreen()
    }
}