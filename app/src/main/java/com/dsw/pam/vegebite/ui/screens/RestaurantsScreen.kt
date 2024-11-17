package com.dsw.pam.vegebite.ui.screens

import RestaurantViewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dsw.pam.vegebite.components.ErrorMessage
import com.dsw.pam.vegebite.components.LoadingIndicator
import com.dsw.pam.vegebite.components.RestaurantList


@Composable
fun RestaurantsScreen(modifier: Modifier, viewModel: RestaurantViewModel = viewModel()) {
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
            )
        }
    }
}
