package com.dsw.pam.vegebite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dsw.pam.vegebite.ui.theme.VegeBiteTheme
import com.dsw.pam.vegebite.ui.screens.RestaurantsScreen
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
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
    navController: NavHostController = rememberNavController()
) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        topBar = {
            TopNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Route.Home> {
                RestaurantsScreen(
                    onRestaurantClick = { restaurantId ->
                        navController.navigate(Route.RestaurantDetails(restaurantId))
                    },
                )
            }

            composable<Route.RestaurantDetails>
             { backStackEntry ->
                val args = backStackEntry.toRoute<Route.RestaurantDetails>()

                RestaurantDetailsScreen(
                    restaurantId = args.restaurantId
                )
            }
            composable<Route.Map> {
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
            onRestaurantClick = {}
        )
    }
}