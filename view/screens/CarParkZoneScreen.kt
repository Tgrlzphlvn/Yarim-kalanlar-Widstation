package com.ozpehlivantugrul.widstation.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ozpehlivantugrul.widstation.utils.Routes
import com.ozpehlivantugrul.widstation.viewmodel.CarParkZoneViewModel


@Composable
fun CarParkZoneScreen(
    navController: NavController,
    carParkZoneViewModel: CarParkZoneViewModel = hiltViewModel()
) {

    var parkZone by remember {
        mutableStateOf("")
    }

    var color by remember {
        mutableStateOf(Color.White)
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
                    text = "Park Alanı",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            Box(
                modifier = Modifier
                    .background(color, shape = RoundedCornerShape(20.dp))

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = parkZone,
                            shape = RoundedCornerShape(20.dp),
                            placeholder = { Text(text = "Park yeri", fontSize = 12.sp)},
                            onValueChange = { parkZone = it }

                        )
                    }
                    LazyRow(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, bottom = 30.dp)
                    ) {
                        items(carParkZoneViewModel.colors) { sColor ->
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(Color.Black, shape = RoundedCornerShape(20.dp))

                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(25.dp)
                                        .background(
                                            color = sColor,
                                            shape = RoundedCornerShape(20.dp)
                                        )
                                        .clickable {
                                            color = sColor
                                        }
                                ) {

                                }
                            }
                        }
                    }
                    Button(onClick = {
                        carParkZoneViewModel.saveCarParkZone(zone = parkZone, color = color.toArgb())
                        navController.navigate(Routes.home) {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    }) {
                        Text(text = "Kaydet")
                    }
                }
            }
        }
    }
}