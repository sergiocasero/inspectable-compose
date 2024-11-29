package com.sergiocasero.inspectable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun InspectableUI(
    config: Boolean,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalInspectConfig provides config) {
        content()
    }
}
