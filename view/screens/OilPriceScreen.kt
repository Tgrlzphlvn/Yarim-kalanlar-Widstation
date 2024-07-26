package com.ozpehlivantugrul.widstation.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.ozpehlivantugrul.widstation.service.scrapOilPrices
import com.ozpehlivantugrul.widstation.service.scrapOilPricesToList
import com.ozpehlivantugrul.widstation.viewmodel.OilPriceViewModel

@Composable
fun OilPriceScreen(navController: NavController, oilPriceViewModel: OilPriceViewModel = hiltViewModel()) {

    val items by oilPriceViewModel.oilPriceList.observeAsState()

    LaunchedEffect(key1 = Unit) {
        scrapOilPrices(oilPriceViewModel = oilPriceViewModel)
        scrapOilPricesToList(oilPriceViewModel = oilPriceViewModel)
    }

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .height(100.dp)
                    .padding(20.dp)
            ) {
                Text(
                    text = "Akaryakıt Fiyatları",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(it)
        ) {
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 5.dp, top = 5.dp, end = 20.dp)
            ) {
                Text(
                    text = "Şirket",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(2.5f)
                )
                Text(
                    text = "Benzin",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Motorin",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "LPG",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
            HorizontalDivider()

            if (!items.isNullOrEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(items!!) { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                                modifier = Modifier.weight(3f)
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(item.image),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .size(30.dp)
                                )
                                Text(
                                    text = item.company,
                                    fontSize = 12.sp
                                )
                            }

                            Text(
                                text = item.benzin,
                                fontSize = 12.sp,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = item.motorin,
                                fontSize = 12.sp,
                                modifier = Modifier.weight(1f)

                            )
                            Text(
                                text = item.lpg,
                                fontSize = 12.sp,
                                modifier = Modifier.weight(1f)

                            )
                        }
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}