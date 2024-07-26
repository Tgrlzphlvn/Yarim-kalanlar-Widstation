package com.ozpehlivantugrul.widstation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.ozpehlivantugrul.widstation.service.scrapOilPrices
import com.ozpehlivantugrul.widstation.ui.theme.WidstationTheme
import com.ozpehlivantugrul.widstation.view.navigation.MainNavigation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WidstationTheme {
                MainNavigation()
            }
        }
    }
}
