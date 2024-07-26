package com.ozpehlivantugrul.widstation.glance.widget

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.currentState
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.Text
import com.ozpehlivantugrul.widstation.viewmodel.OilPriceViewModel
import javax.inject.Inject

class OilPriceWidget @Inject constructor(
    private val oilPriceViewModel: OilPriceViewModel
) : GlanceAppWidget() {
    val widgetHeight = intPreferencesKey("widgetHeight")
    val widgetWidth = intPreferencesKey("widgetWidth")
    val oilPriceListKey = intPreferencesKey("oilListKey")
    val displayedOilPriceIndexKey = intPreferencesKey("displayedWalletIndex")

    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            val oilListAsString = currentState(key = oilPriceListKey)
            val oilPrice = oilPriceViewModel.oilPrice.value

            val displayedOilPriceIndex = currentState(key = displayedOilPriceIndexKey)
            val widgetHeight = currentState(key = widgetHeight)
            val widgetWidth = currentState(key = widgetWidth)

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {

                Box(
                ) {
                    if (oilPrice != null) {
                        Text(text = oilPrice.company)
                        Text(text = oilPrice.benzin)
                        Text(text = oilPrice.motorin)
                        Text(text = oilPrice.lpg)
                    } else {
                        Text(text = "Veri yok!")
                    }
                }
            }
        }
    }
}