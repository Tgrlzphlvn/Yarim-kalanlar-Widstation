package com.ozpehlivantugrul.widstation.glance

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.ozpehlivantugrul.widstation.glance.widget.OilPriceWidget
import com.ozpehlivantugrul.widstation.viewmodel.OilPriceViewModel
import kotlinx.coroutines.MainScope
import javax.inject.Inject

class OilPriceWidgetReceiver @Inject constructor(
    private val oilPriceViewModel: OilPriceViewModel
) : GlanceAppWidgetReceiver() {
    private val coroutineScope = MainScope()

    override val glanceAppWidget: GlanceAppWidget
        get() = OilPriceWidget(oilPriceViewModel = oilPriceViewModel)
}