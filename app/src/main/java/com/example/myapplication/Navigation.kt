package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

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
                    defaultValue = ""
                    nullable = true
                }
            )
        )
        { entry ->
            Screen2(text = entry.arguments!!.getString("text")!!)
        }
    }
}


@Composable
fun MainScreen(navController: NavController) {
    var counter by remember {
        mutableIntStateOf(0)
    }

    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "$counter")

        Button(
            onClick = {
                navController.navigate(Screen.Screen1.withArgs(counter.toString()))
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "1st screen Int")
        }

        Button(
            onClick = {
                navController.navigate(Screen.Screen2.withArgs(text))
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "2nd screen Send text of TextField")
        }

        Button(
            onClick = { counter++ },
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = "Count +1")
        }

        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}

@Composable
fun Screen1(value: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = value,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Screen2(text: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = text,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}