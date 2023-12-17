package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.screens.MainScreen
import com.example.myapplication.screens.Screen1
import com.example.myapplication.screens.Screen2

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {

        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.Screen1.route + "/{counted}",
            arguments = listOf(
                navArgument("counted") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        )
        { entry ->
            Screen1(value = entry.arguments!!.getString("counted")!!)
        }

        composable(
            route = Screen.Screen2.route + "/{text}",
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                    defaultValue = "error"
                    nullable = true
                }
            )
        )
        { entry ->
            Screen2(text = entry.arguments?.getString("text")?: "No str")
        }
    }
}