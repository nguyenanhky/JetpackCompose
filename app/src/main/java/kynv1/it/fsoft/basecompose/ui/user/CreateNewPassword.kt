package kynv1.it.fsoft.basecompose.ui.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kynv1.it.fsoft.basecompose.ui.theme.AppTheme
import kynv1.it.fsoft.basecompose.ui.theme.AppTypography
import kynv1.it.fsoft.basecompose.ui.theme.LocalAppTypography

@Composable
fun CreateNewPasswordScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {


        Text(
            "Create New Password",
            style = AppTheme.appTypography.largeTitle
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Enter your new password. If you forget it, then you have to do forgot password.",
            style = AppTheme.appTypography.body
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = {

            })
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Remember me")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, name = "Light Theme")
@Composable
fun CreateNewPasswordScreenPreview() {
    AppTheme {
        CreateNewPasswordScreen()
    }
}
