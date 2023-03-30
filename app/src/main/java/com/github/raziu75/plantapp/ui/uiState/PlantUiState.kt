package com.github.raziu75.plantapp.ui.uiState

interface PlantUiState {
    object Loading: PlantUiState
    object Error: PlantUiState
    data class Success(val search: String): PlantUiState

}