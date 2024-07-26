package com.ozpehlivantugrul.widstation.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ozpehlivantugrul.widstation.utils.Routes
import com.ozpehlivantugrul.widstation.view.HomeScreen
import com.ozpehlivantugrul.widstation.view.screens.CarParkZoneScreen
import com.ozpehlivantugrul.widstation.view.screens.CurrencyScreen
import com.ozpehlivantugrul.widstation.view.screens.GoldSilverScreen
import com.ozpehlivantugrul.widstation.view.screens.OilPriceScreen
import okhttp3.Route


@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.home) {
        composable(Routes.home) { HomeScreen(navController = navController) }
        composable(Routes.oilPrice) { OilPriceScreen(navController = navController) }
        composable(Routes.parkZone) { CarParkZoneScreen(navController = navController) }
        composable(Routes.goldSilver) { GoldSilverScreen(navController = navController) }
        composable(Routes.currency) { CurrencyScreen(navController = navController) }
    }
}