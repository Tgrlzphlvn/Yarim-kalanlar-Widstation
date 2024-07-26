package com.ozpehlivantugrul.widstation.service

import com.ozpehlivantugrul.widstation.model.CurrencyModel
import com.ozpehlivantugrul.widstation.viewmodel.CurrencyViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element


fun currencyScrapingService(currencyViewModel: CurrencyViewModel) {
    CoroutineScope(Dispatchers.IO).launch {
        val url = "https://bigpara.hurriyet.com.tr/doviz/"
        val document: Document = Jsoup.connect(url).get()
        val tableBox = document.select("div.tableBox.srbstPysDvz")
        val tBody = tableBox.select("div.tBody")

        val currencyList = mutableListOf<CurrencyModel>()


        for (element: Element in tBody.select("ul")) {
            val name = element.select("li.cell010").text()
            val buyPrice = element.select("li.cell015").eq(0).text()
            val sellPrice = element.select("li.cell015").eq(1).text()
            val changePercent = element.select("li.cell015").eq(2).text()


            val model = CurrencyModel(
                dovizAdi = name,
                alis = buyPrice,
                satis = sellPrice,
                degisim = changePercent
            )

            currencyList.add(model)
        }

        currencyViewModel.updateCurrencyList(currencyList = currencyList)

        currencyList.forEach {
            println("Şirket: ${it.dovizAdi}, Alış: ${it.alis}, Satış: ${it.satis}, degisim: ${it.degisim}")
        }
    }
}
