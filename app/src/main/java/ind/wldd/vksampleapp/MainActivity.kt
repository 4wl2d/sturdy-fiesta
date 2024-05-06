package ind.wldd.vksampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ind.wldd.vksampleapp.presentation.ui.theme.VkSampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkSampleAppTheme {

            }
        }
    }
}