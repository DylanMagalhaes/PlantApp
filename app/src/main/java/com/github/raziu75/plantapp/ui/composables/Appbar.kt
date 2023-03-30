package com.github.raziu75.plantapp.ui.composables

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun  Appbar() {
    TopAppBar(title = { Text(text = "Recherche de plante") })
}