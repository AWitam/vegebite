package com.dsw.pam.vegebite.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.dsw.pam.vegebite.R
import com.dsw.pam.vegebite.domain.Restaurant
import com.dsw.pam.vegebite.domain.RestaurantUiState


class RestaurantViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(RestaurantUiState(isLoading = true))
    val uiState: StateFlow<RestaurantUiState> = _uiState.asStateFlow()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        viewModelScope.launch {
            try {

                kotlinx.coroutines.delay(1000)
                val restaurants = listOf(
                    Restaurant(
                        id = 1,
                        name = "Italian Delight",
                        description = "Authentic Italian cuisine featuring homemade pasta, wood-fired pizzas, and fresh ingredients imported directly from Italy. Our chef brings 20 years of experience from Naples.",
                        imageRes = R.drawable.sample_restaurant,
                        address = "123 Main St, San Francisco, CA"
                    ),
                    Restaurant(
                        id = 2,
                        name = "Vegan Vibes",
                        description = "Healthy and delicious plant-based meals that are good for you and the planet. Our menu features a variety of dishes from around the world, all made with love.",
                        imageRes = R.drawable.sample_restaurant,
                        address = "456 Elm St, San Francisco, CA"
                    )
                )

                _uiState.value = RestaurantUiState(restaurants = restaurants)
            } catch (e: Exception) {
                _uiState.value = RestaurantUiState(error = "Failed to load restaurants: ${e.message}")
            }
        }
    }

}
fun RestaurantUiState.getRestaurant(restaurantId: Int): Restaurant? {
    return restaurants.find { it.id == restaurantId }
}