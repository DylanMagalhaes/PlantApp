package com.github.raziu75.plantapp.ui.uiState

import com.github.raziu75.plantapp.model.APIResults

interface PlantUiState {
    object Loading: PlantUiState
    data class Error(val error: String): PlantUiState
    data class Success(val search: APIResults): PlantUiState

}