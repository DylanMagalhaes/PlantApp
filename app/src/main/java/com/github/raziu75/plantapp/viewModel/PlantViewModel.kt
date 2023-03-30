package com.github.raziu75.plantapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.raziu75.plantapp.data.PlantAPI
import com.github.raziu75.plantapp.model.APIResults
import com.github.raziu75.plantapp.ui.uiState.PlantUiState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class PlantViewModel : ViewModel() {
    //Etat de la TextField
    var plantName: String by mutableStateOf("")

    //Etat de l'appel API
    var plantState: PlantUiState by mutableStateOf(PlantUiState.Loading)


    fun updateTextFieldValue(text: String) {
        plantName = text
    }

    fun launchAPI() {
        //lancement de coroutine avec PlantService
        viewModelScope.launch {
            plantState = try {
                val result = PlantAPI.service.getPlant(q = plantName)
                println(result)
                PlantUiState.Success(search = convertDatas(result))

            } catch (iO: IOException) {
                PlantUiState.Error(error = iO.message?: "")

            } catch (http: HttpException) {
                PlantUiState.Error(error = http.message?: "")
            }
        }
    }

    fun convertDatas(string: String): APIResults {
        val gson = Gson()
        val type = object : TypeToken<APIResults>() {}.type
        return gson.fromJson(string, type)
    }
}