package com.example.finalspaceapi.navigation

sealed class Screen(val route: String) {

    object SpaceListScreen : Screen("coin_list_screen")

    object FinalSpaceDetailsScreen : Screen("final_space_detail_screen")
}