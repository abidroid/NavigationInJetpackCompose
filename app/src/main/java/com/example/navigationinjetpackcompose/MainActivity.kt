package com.example.navigationinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationinjetpackcompose.ui.theme.NavigationInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNavigations()
        }
    }
}

@Composable
fun MyNavigations() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable(route = "MainScreen") {
            MainScreen(navController)
        }

        composable(route = "SecondScreen") {
            SecondScreen(navController)
        }

        composable(route = "ThirdScreen") {
            ThirdScreen(navController)
        }

        composable(
            route = "FourthScreen/{name}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                }
            )

        ) {navBackStackEntry ->

            val name = navBackStackEntry.arguments?.getString("name")

            name?.let {
                FourthScreen(navController, it)
            }

        }
    }
}