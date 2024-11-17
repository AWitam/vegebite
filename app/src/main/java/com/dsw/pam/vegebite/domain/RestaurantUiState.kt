package com.dsw.pam.vegebite.domain

data class RestaurantUiState(
    val restaurants: List<Restaurant> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
