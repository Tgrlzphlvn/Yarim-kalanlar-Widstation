package com.ozpehlivantugrul.widstation.service


import com.ozpehlivantugrul.widstation.model.OilPriceModel
import com.ozpehlivantugrul.widstation.viewmodel.OilPriceViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

fun scrapOilPrices(oilPriceViewModel: OilPriceViewModel) {

    CoroutineScope(Dispatchers.IO).launch {
        val url = "https://www.doviz.com/akaryakit-fiyatlari/istanbul-anadolu"
        val document: Document = Jsoup.connect(url).get()

        val div: Element? = document.select("div.value-table").first()
        val table: Element? = div?.select("table")?.first()

        val value1 = document.select("td.text-bold.p-12.text-center").textNodes().get(0)
        val value2 = document.select("td.text-bold.p-12.text-center").textNodes().get(1)
        val value3 = document.select("td.text-bold.p-12.text-center").textNodes().get(2)
        val image = document.select("img").attr("src")
        val company = document.select("span.ml-8").textNodes().first()

        oilPriceViewModel.getOilPriceModel(
            company = company.toString(),
            image = image.toString(),
            benzin = value1.toString(),
            motorin = value2.toString(),
            lpg = value3.toString()
        )

        val rows: Elements? = table?.select("tr")

        if (rows != null)
            for (row in rows) {
                val cols: Elements = row.select("td")
                for (col in cols) {
                    //println(col.text())
                }
            }
    }
}

fun scrapOilPricesToList(oilPriceViewModel: OilPriceViewModel) {
    CoroutineScope(Dispatchers.IO).launch {
        val url = "https://www.doviz.com/akaryakit-fiyatlari/istanbul-avrupa/fatih"
        val document: Document = Jsoup.connect(url).get()

        val oilPriceList = mutableListOf<OilPriceModel>()
        val rows: Elements? = document.select("div.value-table table tr")

        rows?.forEach { row ->
            val cols = row.select("td")

            if (cols.size >= 5) {
                val company = cols[0].select("span.ml-8").text()
                val image = cols[0].select("img").attr("src")
                val benzin = cols[1].text()
                val dizel = cols[2].text()
                val lpg = cols[3].text()

                val oilPriceModel = OilPriceModel(
                    company = company,
                    image = image,
                    benzin = benzin,
                    motorin = dizel,
                    lpg = lpg
                )
                oilPriceList.add(oilPriceModel)
            }
        }

        // Verileri ViewModel'e ekleyin veya UI'ı güncelleyin
        oilPriceViewModel.updateOilPriceList(oilPriceList)

        // Test amaçlı ekrana yazdırın
        oilPriceList.forEach {
            println("Şirket: ${it.company}, İmage: ${it.image}, Benzin: ${it.benzin}, Dizel: ${it.motorin}, LPG: ${it.lpg}")
        }
    }
}