package com.example.finalspaceapi.presentation.final_space_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.finalspaceapi.navigation.Screen
import com.example.finalspaceapi.presentation.final_space_list.components.ConnectivityStatus
import com.example.finalspaceapi.presentation.final_space_list.components.SingleListItem
import com.example.finalspaceapi.ui.spacing
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun FinalSpaceScreen(
    viewModel: FinalSpaceListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.medium)
        ) {
            item {
                ConnectivityStatus()
            }
            items(state.finalSpace) { finalSpaceItem ->
                SingleListItem(finalSpaceItemDto = finalSpaceItem,
                    onItemClick = {
                        navController.navigate(Screen.FinalSpaceDetailsScreen.route + "/${finalSpaceItem.id}")
                    })
                Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.secondary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.large)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}