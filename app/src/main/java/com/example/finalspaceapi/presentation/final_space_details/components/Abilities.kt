package com.example.finalspaceapi.presentation.final_space_details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun Abilities(
    tag: String
) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = tag
                .replace("[\\[\\]^,\"]+".toRegex(), "\n"),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
}