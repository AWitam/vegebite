package com.dsw.pam.vegebite.navigation



sealed class Route(val route: String) {
    object Home : Route("home")
    object RestaurantDetails : Route("details/{restaurantId}") {
        fun createRoute(restaurantId: Int) = "details/$restaurantId"
    }
    object Map : Route("map")
}