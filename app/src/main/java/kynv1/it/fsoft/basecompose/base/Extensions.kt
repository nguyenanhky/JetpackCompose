package kynv1.it.fsoft.basecompose.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController

@Composable
fun <T> NavController.GetResultOneTime(key:String, onResult:(T?)->Unit) {
    val valueScreenResult = currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<T>(key)?.observeAsState()

    onResult(valueScreenResult?.value)
    currentBackStackEntry
        ?.savedStateHandle
        ?.remove<T>(key)
}
