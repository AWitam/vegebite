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
import com.dsw.pam.vegebite.ui.theme.VegeBiteTheme
import com.dsw.pam.vegebite.screens.RestaurantsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VegeBiteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RestaurantsScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VegeBiteTheme {
        RestaurantsScreen(modifier = Modifier)
    }
}