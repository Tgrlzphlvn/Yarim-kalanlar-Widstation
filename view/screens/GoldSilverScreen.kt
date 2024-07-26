package com.ozpehlivantugrul.widstation.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
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
import com.ozpehlivantugrul.widstation.service.goldSilverScrapingService
import com.ozpehlivantugrul.widstation.viewmodel.GoldSilverViewModel


@Composable
fun GoldSilverScreen(navController: NavController, goldSilverViewModel: GoldSilverViewModel = hiltViewModel()) {

    val items by goldSilverViewModel.goldSilverList.observeAsState()


    LaunchedEffect(key1 = Unit) {
        goldSilverScrapingService(goldSilverViewModel = goldSilverViewModel)
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
                    text = "Altın fiyatları",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 5.dp, top = 5.dp, end = 20.dp)
            ) {
                Text(
                    text = "Tür",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(1.7f)
                )
                Text(
                    text = "Alış",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Satış",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Değişim",
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
                            Text(
                                text = item.mineName,
                                fontSize = 12.sp,
                                modifier = Modifier.weight(1.7f)
                            )

                            Text(
                                text = item.alis,
                                fontSize = 12.sp,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = item.satis,
                                fontSize = 12.sp,
                                modifier = Modifier.weight(1f)

                            )
                            Text(
                                text = item.degisim,
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