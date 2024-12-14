package com.dsw.pam.vegebite.components

import com.dsw.pam.vegebite.ui.screens.RestaurantViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dsw.pam.vegebite.navigation.Route
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    navController: NavHostController,
    viewModel: RestaurantViewModel = koinViewModel()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?:Route.Home

    TopAppBar(
        title = {
            Text(
                text = when (currentRoute) {
                    Route.Home -> "Restaurants"
                    Route.Map -> "Map"
                    else -> "Restaurant Details"
                }
            )
        },
        navigationIcon = {
            if (currentRoute != Route.Home && currentRoute != Route.Map) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                }
            }
        }
    )
}