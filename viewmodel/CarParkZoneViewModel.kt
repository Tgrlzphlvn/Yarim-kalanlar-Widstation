package com.ozpehlivantugrul.widstation.viewmodel

import android.content.SharedPreferences
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.ozpehlivantugrul.widstation.model.CarParkZone
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CarParkZoneViewModel @Inject constructor(
    private val sharedPref: SharedPreferences
): ViewModel() {

    private val zoneSharedKey = "zoneSharedKey"
    private val zoneColor = "zoneColor"

    private val orange = Color(255, 130, 37)
    private val silver = Color(248, 237, 237)
    private val purple = Color(105, 79, 142)


    val colors = listOf<Color>(
        Color.White,
        Color.Black,
        Color.Yellow,
        Color.Red,
        Color.Blue,
        Color.Magenta,
        Color.Green,
        Color.Gray,
        Color.DarkGray,
        orange,
        silver,
        purple
    )

    fun saveCarParkZone(zone: String, color: Int) {
        sharedPref.edit().putString(zoneSharedKey, zone).apply()
        sharedPref.edit().putInt(zoneColor, color).apply()
    }

    fun getCarParkZone(): CarParkZone {
        val zone = sharedPref.getString(zoneSharedKey, "null") ?: "nullElse"
        val color = sharedPref.getInt(zoneColor, 0)
        return CarParkZone(zone = zone, color = color)
    }
}
