package com.example.finalspaceapi.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalspaceapi.presentation.final_space_details.FinalSpaceDetailsScreen
import com.example.finalspaceapi.presentation.final_space_list.FinalSpaceListViewModel
import com.example.finalspaceapi.presentation.final_space_list.FinalSpaceScreen
import com.example.finalspaceapi.presentation.final_space_settings.SettingsScreen
import com.example.finalspaceapi.presentation.final_space_settings.preferences.UserSettings
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: FinalSpaceListViewModel = hiltViewModel(),
    userSettings: UserSettings
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SpaceListScreen.route
    ) {
        composable(route = Screen.SpaceListScreen.route) {
            FinalSpaceScreen(viewModel, navController)
        }

        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(userSettings,navController)
        }
        composable(
            route = Screen.FinalSpaceDetailsScreen.route + "/{id}"
        ) {
            FinalSpaceDetailsScreen(navController)
        }
    }
}