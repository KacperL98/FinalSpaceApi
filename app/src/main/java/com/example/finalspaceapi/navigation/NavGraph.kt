package com.example.finalspaceapi.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalspaceapi.presentation.final_space_details.FinalSpaceDetailsScreen
import com.example.finalspaceapi.presentation.final_space_list.FinalSpaceListViewModel
import com.example.finalspaceapi.presentation.final_space_list.FinalSpaceScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: FinalSpaceListViewModel = hiltViewModel(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SpaceListScreen.route
    ) {
        composable(route = Screen.SpaceListScreen.route) {
            FinalSpaceScreen(viewModel,navController)
        }
        composable(
            route = Screen.FinalSpaceDetailsScreen.route + "/{id}"
        ) {
            FinalSpaceDetailsScreen()
        }
    }
}