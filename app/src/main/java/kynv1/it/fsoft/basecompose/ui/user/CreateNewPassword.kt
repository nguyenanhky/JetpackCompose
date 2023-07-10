package kynv1.it.fsoft.basecompose.ui.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kynv1.it.fsoft.basecompose.ui.theme.AppColor
import kynv1.it.fsoft.basecompose.ui.theme.AppTheme

@Composable
fun CreateNewPasswordScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(color = AppTheme.appColor.backgroundColor)
    ) {

        Text(
            "Create New Password \uD83D\uDD10",
            style = AppTheme.appTypography.largeTitle.copy(
                fontSize = 56.sp,
                color = AppTheme.appColor.textBodyColor
            )
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
    AppTheme(isDark = false) {
        CreateNewPasswordScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Dark Theme")
@Composable
fun CreateNewPasswordScreenPreviewDark() {
    AppTheme(isDark = true) {
        CreateNewPasswordScreen()
    }
}

