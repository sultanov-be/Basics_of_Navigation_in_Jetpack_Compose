package com.example.myapplication

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object Screen1: Screen("1st_screen")
    object Screen2: Screen("2nd_screen")

    fun withArgs(vararg args: String) : String =
        buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
}