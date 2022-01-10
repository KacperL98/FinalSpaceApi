package com.example.finalspaceapi.presentation.final_space_details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CharacterDetailsRow(
    label: String,
    separator: @Composable (RowScope.() -> Unit) = {},
    labelStyle: TextStyle = MaterialTheme.typography.body1,
) {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$label ",
            style = labelStyle,
            fontWeight = FontWeight.Bold
        )
        separator()
    }
}