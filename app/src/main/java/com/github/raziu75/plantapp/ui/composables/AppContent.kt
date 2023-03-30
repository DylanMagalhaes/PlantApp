package com.github.raziu75.plantapp.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.raziu75.plantapp.model.APIResults
import com.github.raziu75.plantapp.ui.uiState.PlantUiState
import com.github.raziu75.plantapp.viewModel.PlantViewModel

@Composable
fun AppContent(modifier: Modifier, vm: PlantViewModel = viewModel()) {
    val  manager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = vm.plantName ,
            onValueChange = { vm.updateTextFieldValue(it)},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                vm.launchAPI()
                manager.clearFocus()
            }),
            label = { Text(text = "Entrez une plante") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(onClick = {
                    vm.launchAPI()
                    manager.clearFocus()
                }) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = null)
                }
            }
        )

        when (vm.plantState) {
            is PlantUiState.Loading -> LoadingView()
            is PlantUiState.Error -> ErrorView(error = (vm.plantState as PlantUiState.Error).error)
            is PlantUiState.Success -> PlantCard(result = (vm.plantState as PlantUiState.Success).search)

        }
    }
}