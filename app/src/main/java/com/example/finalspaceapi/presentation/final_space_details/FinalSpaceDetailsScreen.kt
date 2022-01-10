package com.example.finalspaceapi.presentation.final_space_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.finalspaceapi.presentation.final_space_details.components.CollapsingToolbar

@ExperimentalMaterialApi
@Composable
fun FinalSpaceDetailsScreen(
    navController: NavController,
    viewModel: FinalSpaceDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.detailsCharacter?.let {
            CollapsingToolbar(it, navController)
        }
    }
}