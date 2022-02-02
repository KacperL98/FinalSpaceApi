package com.example.finalspaceapi.presentation.final_space_settings.preferences

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import com.example.finalspaceapi.ui.spacing

data class RadioButtonItem(
    val id: Int,
    val title: String,
)

@Composable
fun RadioGroupOptions(
    items: Iterable<RadioButtonItem>,
    selected: Int,
    onItemSelect: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.selectableGroup()
    ) {
        items.forEach { item ->
            RadioGroupItem(
                item = item,
                selected = selected == item.id,
                onClick = { onItemSelect?.invoke(item.id) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun RadioGroupItem(
    item: RadioButtonItem,
    selected: Boolean,
    onClick: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .selectable(
                selected = selected,
                onClick = { onClick?.invoke(item.id) },
                role = Role.RadioButton
            )
            .padding(MaterialTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = null,
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
        Text(
            text = item.title,
            style = MaterialTheme.typography.body1,
        )
    }
}
