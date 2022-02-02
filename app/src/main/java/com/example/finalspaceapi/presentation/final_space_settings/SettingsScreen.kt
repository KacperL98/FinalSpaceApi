package com.example.finalspaceapi.presentation.final_space_settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.finalspaceapi.R
import com.example.finalspaceapi.navigation.Screen
import com.example.finalspaceapi.presentation.common_extensions.TopAppBarWithIconLeft
import com.example.finalspaceapi.presentation.final_space_settings.preferences.AppTheme
import com.example.finalspaceapi.presentation.final_space_settings.preferences.RadioButtonItem
import com.example.finalspaceapi.presentation.final_space_settings.preferences.RadioGroupOptions
import com.example.finalspaceapi.presentation.final_space_settings.preferences.UserSettings
import com.example.finalspaceapi.ui.spacing
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Composable
fun SettingsScreen(
    userSettings: UserSettings,
    navController: NavController
) {
    Surface(color = MaterialTheme.colors.background) {
        ThemeSwitch(
            userSettings, navController
        ) { theme ->
            userSettings.theme = theme
        }
    }
}

@Composable
fun ThemeSwitch(
    userSettings: UserSettings,
    navController: NavController,
    onItemSelected: (AppTheme) -> Unit
) {
    val theme = userSettings.themeStream.collectAsState()
    val themeItems = listOf(
        RadioButtonItem(
            id = AppTheme.LIGHT_MODE.ordinal,
            title = stringResource(id = R.string.light),
        ),
        RadioButtonItem(
            id = AppTheme.DARK_MODE.ordinal,
            title = stringResource(id = R.string.dark),
        ),
        RadioButtonItem(
            id = AppTheme.AUTO_MODE.ordinal,
            title = stringResource(id = R.string.auto),
        ),
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBarWithIconLeft(
            title = stringResource(id = R.string.back),
            onClickScreen = { navController.navigate(route = Screen.SpaceListScreen.route) },
            imageVector = Icons.Filled.ArrowBack,
        )
        Text(
            text = stringResource(id = R.string.select_theme),
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small
                )
        )
        RadioGroupOptions(
            items = themeItems,
            selected = theme.value.ordinal,
            onItemSelect = { id ->
                onItemSelected(AppTheme.fromOrdinal(id))
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}