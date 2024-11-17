package com.dsw.pam.vegebite

import RestaurantViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dsw.pam.vegebite.ui.theme.VegeBiteTheme
import com.dsw.pam.vegebite.ui.screens.RestaurantsScreen
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dsw.pam.vegebite.components.BottomNavigationBar
import com.dsw.pam.vegebite.components.TopNavigationBar
import com.dsw.pam.vegebite.navigation.Route
import com.dsw.pam.vegebite.ui.screens.MapScreen
import com.dsw.pam.vegebite.ui.screens.RestaurantDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            VegeBiteTheme {
                AppNavHost()
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    viewModel: RestaurantViewModel = viewModel()
) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        topBar = {
            TopNavigationBar(navController = navController, viewModel = viewModel)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Route.Home.route) {
                RestaurantsScreen(
                    onRestaurantClick = { restaurantId ->
                        navController.navigate(Route.RestaurantDetails.createRoute(restaurantId))
                    },
                    viewModel = viewModel
                )
            }

            composable(
                route = Route.RestaurantDetails.route,
                arguments = listOf(
                    navArgument("restaurantId") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val restaurantId =
                    backStackEntry.arguments?.getInt("restaurantId") ?: return@composable
                RestaurantDetailsScreen(
                    restaurantId = restaurantId,
                    viewModel = viewModel,
                    onBackClick = { navController.popBackStack() }
                )
            }
            composable(Route.Map.route) {
                MapScreen()
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    VegeBiteTheme {
        RestaurantsScreen(
            onRestaurantClick = {},
            viewModel = viewModel()
        )
    }
}