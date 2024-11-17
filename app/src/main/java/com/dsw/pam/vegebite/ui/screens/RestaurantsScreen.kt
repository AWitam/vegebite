package com.dsw.pam.vegebite.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dsw.pam.vegebite.R
import com.dsw.pam.vegebite.components.RestaurantCard
import com.dsw.pam.vegebite.domain.Restaurant


@Composable
fun RestaurantsScreen(modifier:Modifier) {
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
        ),

    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(restaurants) { restaurant ->
            RestaurantCard(restaurant = restaurant)
        }
    }
}
