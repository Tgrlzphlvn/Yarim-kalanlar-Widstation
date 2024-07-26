package com.ozpehlivantugrul.widstation.service

import com.ozpehlivantugrul.widstation.model.GoldSilverModel
import com.ozpehlivantugrul.widstation.viewmodel.GoldSilverViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

fun goldSilverScrapingService(goldSilverViewModel: GoldSilverViewModel) {
    CoroutineScope(Dispatchers.IO).launch {

        val url = "https://altin.doviz.com/"
        val document: Document = Jsoup.connect(url).get()

        val goldSilverList = mutableListOf<GoldSilverModel>()

        val rows: Elements? = document.select("div.value-table table tr")

        rows?.forEach { row ->
            val cols = row.select("td")

            if (cols.size >= 5 ) {
                val mineMane = cols[0].text()
                val alis = cols[1].text()
                val satis = cols[2].text()
                val degisim = cols[3].text()

                val goldSilverModel = GoldSilverModel(
                    mineName = mineMane,
                    alis = alis,
                    satis = satis,
                    degisim = degisim
                )

                goldSilverList.add(goldSilverModel)
            }
        }
        goldSilverViewModel.updateGoldSilverList(goldSilverList)

        /*goldSilverList.forEach {
            println("Şirket: ${it.mineName}, Alış: ${it.alis}, Satış: ${it.satis}, degisim: ${it.degisim}")
        }*/
    }
}