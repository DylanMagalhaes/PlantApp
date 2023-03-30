package com.github.raziu75.plantapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.raziu75.plantapp.data.PlantAPI
import com.github.raziu75.plantapp.ui.uiState.PlantUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class PlantViewModel : ViewModel() {
    //Etat de la TextField
    var plantName: String by mutableStateOf("")

    //Etat de l'appel API
    var plantUiState: PlantUiState by mutableStateOf(PlantUiState.Loading)


    fun updateTextFieldValue(text: String) {
        plantName = text
    }

    fun launchAPI() {
        //lancement de coroutine avec PlantService
        viewModelScope.launch {
            plantUiState = try {
                val result = PlantAPI.service.getPlant(q = plantName)
                PlantUiState.Success(search = result)

            } catch (iO: IOException){
                println(iO.message)
                PlantUiState.Error

            } catch (http: HttpException){
                println(http.message)
                PlantUiState.Error
            }
        }
    }
}