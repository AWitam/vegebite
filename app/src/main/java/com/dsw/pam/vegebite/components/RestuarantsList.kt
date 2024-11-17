package com.dsw.pam.vegebite.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dsw.pam.vegebite.domain.Restaurant

@Composable
fun RestaurantList(
    restaurants: List<Restaurant>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(restaurants) { restaurant ->
            RestaurantCard(
                restaurant = restaurant
            )
        }
    }
}