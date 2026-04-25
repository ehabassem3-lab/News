package com.example.compose_first.screens.news

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SwitchButton(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit ,

) {

    val colorScheme = MaterialTheme.colorScheme

    Switch(
        checked = isDarkTheme,

        onCheckedChange = {
            onThemeChange(it)
        },

        colors = SwitchDefaults.colors(
            checkedThumbColor = colorScheme.background,
            checkedTrackColor = colorScheme.onBackground,
            uncheckedThumbColor = colorScheme.background,
            uncheckedTrackColor = colorScheme.onBackground
        ),

        modifier = Modifier.scale(scaleX = 1.1f , scaleY = 1f)
    )
}