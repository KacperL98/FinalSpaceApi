package com.example.finalspaceapi.presentation.common_extensions

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.finalspaceapi.R
import com.example.finalspaceapi.ui.spacing

@Composable
fun TopAppBarWithIconLeft(title: String, onClickScreen: () -> Unit, imageVector: ImageVector) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { onClickScreen() }) {
                Icon(imageVector, "")
            }
        },
        contentColor = Color.White,
        elevation = MaterialTheme.spacing.small
    )
}

@Composable
fun TopAppBarWithIconRight(title: String, onClickScreen: () -> Unit, imageVector: ImageVector) {
    TopAppBar(title = {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = Color.White
        )
    }, actions = {
        IconButton(
            modifier = Modifier,
            onClick = { onClickScreen() }) {
            Icon(
                imageVector,
                contentDescription = stringResource(id = R.string.app_name)
            )
        }
    })
}