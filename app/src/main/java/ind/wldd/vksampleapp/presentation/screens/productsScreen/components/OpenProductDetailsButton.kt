package ind.wldd.vksampleapp.presentation.screens.productsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OpenProductDetailsButton(
    text: String,
    modifier: Modifier = Modifier.clickable {
        // there will be the opener
    }
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(10.dp, RoundedCornerShape(10.dp))
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "${text}$", style = MaterialTheme.typography.titleMedium)
    }
}

@Preview
@Composable
private fun OpenProductDetailsButtonPreview() {
    OpenProductDetailsButton(text = "123")
}