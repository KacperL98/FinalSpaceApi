package com.example.finalspaceapi.presentation.final_space_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finalspaceapi.R
import com.example.finalspaceapi.internet_information.NetworkOptions
import com.example.finalspaceapi.internet_information.connectivityState
import com.example.finalspaceapi.ui.spacing
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
@Composable
fun ConnectivityStatus() {
    val connection by connectivityState()

    val isConnected = connection === NetworkOptions.IsConnected

    if (!isConnected) {
        Box(modifier = Modifier.padding(MaterialTheme.spacing.extraSmall)) {
            Text(
                text = stringResource(id = R.string.offline_connection),
                fontSize = 16.sp,
                color = Color.Red,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}