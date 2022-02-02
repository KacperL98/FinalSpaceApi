package com.example.finalspaceapi.presentation.final_space_settings.preferences

import kotlinx.coroutines.flow.StateFlow

enum class AppTheme {
    LIGHT_MODE,
    DARK_MODE,
    AUTO_MODE;

    companion object {
        fun fromOrdinal(ordinal: Int) = values()[ordinal]
    }
}

interface UserSettings {
    val themeStream: StateFlow<AppTheme>
    var theme: AppTheme
}