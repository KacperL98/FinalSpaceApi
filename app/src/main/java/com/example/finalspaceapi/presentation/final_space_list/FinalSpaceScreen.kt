package com.example.finalspaceapi.presentation.final_space_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.finalspaceapi.R
import com.example.finalspaceapi.navigation.Screen
import com.example.finalspaceapi.presentation.common_extensions.TopAppBarWithIconRight
import com.example.finalspaceapi.presentation.final_space_list.components.ConnectivityStatus
import com.example.finalspaceapi.presentation.final_space_list.components.SingleListItem
import com.example.finalspaceapi.ui.spacing
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Composable
fun FinalSpaceScreen(
    viewModel: FinalSpaceListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBarWithIconRight(
                title = stringResource(id = R.string.final_space),
                onClickScreen = { navController.navigate(route = Screen.SettingsScreen.route) },
                imageVector = Icons.Filled.Settings,
            )
        },
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing),
            onRefresh = { viewModel.refresh() },
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.extraSmall)
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
        }
        if (state.error.isNotBlank()) {
            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.secondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                )
            }
        }
        if (state.isLoading) {
            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }
}