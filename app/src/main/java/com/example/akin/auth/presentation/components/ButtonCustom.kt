package com.example.akin.auth.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.akin.R


sealed class ButtonSize {
    object Large : ButtonSize()
    object Small : ButtonSize()
}

@Composable
fun ButtonCustom(
    onClick: () -> Unit,
    buttonSize: ButtonSize = ButtonSize.Large,
    label: String,
    imageVector: ImageVector? = null,
    backgroundColor: Color,
) {

    val size = when (buttonSize) {
        ButtonSize.Large -> 300.dp
        ButtonSize.Small -> 136.dp
    }

    //val sourceImage = painterResource(id = R.drawable.google_icon)

    Button(
        onClick = onClick,
        //enabled = signInUiState.isEntryValid,
        modifier = Modifier.size(size, 54.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color(0xFF000000)
        )
    ) {
        if (imageVector != null) {
            Icon(
                imageVector = imageVector,
                modifier = Modifier
                    .size(26.dp),
                contentDescription = "drawable_icons",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(text = label, fontSize = 12.sp)
    }
}

@SuppressLint("ResourceAsColor")
@Preview()
@Composable
fun ButtomCustomPreview() {
    ButtonCustom(
        onClick = { /*TODO*/ },
        label = "Teste",
        imageVector = ImageVector.vectorResource(R.drawable.google_icon),
        backgroundColor = Color(R.color.orange_100)
    )
}