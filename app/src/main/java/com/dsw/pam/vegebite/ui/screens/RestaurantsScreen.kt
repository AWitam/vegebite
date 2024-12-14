package com.dsw.pam.vegebite.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.dsw.pam.vegebite.components.ErrorMessage
import com.dsw.pam.vegebite.components.LoadingIndicator
import com.dsw.pam.vegebite.components.RestaurantList
import org.koin.androidx.compose.koinViewModel

@Composable
fun RestaurantsScreen(
    onRestaurantClick: (Int) -> Unit, viewModel: RestaurantViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isLoading -> {
            LoadingIndicator()
        }

        uiState.error != null -> {
            ErrorMessage(message = uiState.error!!)
        }

        else -> {
            RestaurantList(
                restaurants = uiState.restaurants,
                onRestaurantClick = onRestaurantClick
            )
        }
    }
}
