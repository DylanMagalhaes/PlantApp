package com.github.raziu75.plantapp.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppScaffold() {
    Scaffold(
        topBar = { Appbar() },
        content = { AppContent(modifier = Modifier.padding(it)) })
}