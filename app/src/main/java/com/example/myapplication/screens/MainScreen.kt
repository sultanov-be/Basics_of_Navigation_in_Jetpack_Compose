package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.navigation.Screen

@Composable
fun MainScreen(navController: NavController) {
    var counter by remember {
        mutableIntStateOf(0)
    }

    var text by remember {
        mutableStateOf("TextField was empty")
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