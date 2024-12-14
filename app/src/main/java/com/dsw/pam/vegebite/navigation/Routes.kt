package com.dsw.pam.vegebite.navigation

import kotlinx.serialization.Serializable


sealed interface Route{
    @Serializable
    object Home : Route
    @Serializable
    data class RestaurantDetails(val restaurantId: Int) : Route
    @Serializable
    object Map : Route
}