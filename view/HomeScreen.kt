package com.ozpehlivantugrul.widstation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ozpehlivantugrul.widstation.service.currencyScrapingService
import com.ozpehlivantugrul.widstation.service.goldSilverScrapingService
import com.ozpehlivantugrul.widstation.utils.Routes
import com.ozpehlivantugrul.widstation.viewmodel.CurrencyViewModel
import com.ozpehlivantugrul.widstation.viewmodel.GoldSilverViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: GoldSilverViewModel = hiltViewModel(),
    currencyViewModel: CurrencyViewModel = hiltViewModel()
) {


    LaunchedEffect(key1 = Unit) {
        goldSilverScrapingService(goldSilverViewModel = viewModel)
        currencyScrapingService(currencyViewModel = currencyViewModel)
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
                    text = "Widstation",
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
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(40.dp)
                    .clickable {
                        navController.navigate(Routes.oilPrice)
                    }
            ) {
                Text(
                    text = "Akaryakıt fiyatları",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(2.5f)
                        .fillMaxWidth()
                )
            }
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(40.dp)
                    .clickable {
                        navController.navigate(Routes.parkZone)
                    }
            ) {
                Text(
                    text = "Park Yeri",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(2.5f)
                        .fillMaxWidth()
                )
            }
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(40.dp)
                    .clickable {
                        navController.navigate(Routes.goldSilver)
                    }
            ) {
                Text(
                    text = "Altın fiyatları",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(2.5f)
                        .fillMaxWidth()
                )
            }
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(40.dp)
                    .clickable {
                        navController.navigate(Routes.currency)
                    }
            ) {
                Text(
                    text = "Döviz fiyatları",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(2.5f)
                        .fillMaxWidth()
                )
            }
            HorizontalDivider()
        }
    }
}