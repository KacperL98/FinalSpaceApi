package com.example.finalspaceapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.finalspaceapi.navigation.SetupNavGraph
import com.example.finalspaceapi.presentation.SplashViewModel
import com.example.finalspaceapi.presentation.final_space_list.FinalSpaceListViewModel
import com.example.finalspaceapi.ui.theme.FinalSpaceApiTheme
import com.example.finalspaceapi.presentation.final_space_settings.preferences.AppTheme
import com.example.finalspaceapi.presentation.final_space_settings.preferences.UserSettings
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()
    private val finalSpaceListViewModel: FinalSpaceListViewModel by viewModels()
    @Inject
    lateinit var userSettings: UserSettings

    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepVisibleCondition {
                splashViewModel.isLoading.value
            }
        }
        setContent {
            val theme = userSettings.themeStream.collectAsState()
            val useDarkColors = when (theme.value) {
                AppTheme.AUTO_MODE -> isSystemInDarkTheme()
                AppTheme.LIGHT_MODE -> false
                AppTheme.DARK_MODE -> true
            }
            FinalSpaceApiTheme(darkTheme = useDarkColors) {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    SetupNavGraph(
                        navController = navController,
                        finalSpaceListViewModel,
                        userSettings
                    )
                }
            }
        }
    }
}