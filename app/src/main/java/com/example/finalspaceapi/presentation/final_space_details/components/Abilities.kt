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
import com.example.finalspaceapi.ui.spacing

@Composable
fun Abilities(
    abilities: String
) {
    Box(
        modifier = Modifier
            .padding(MaterialTheme.spacing.extraSmall)
            .border(
                width = MaterialTheme.spacing.default,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(MaterialTheme.spacing.spacingOthersXX)
            )
            .padding(10.dp)
    ) {
        Text(
            text = abilities
                .replace("[\\[\\]^,\"]+".toRegex(), "\n"),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
}