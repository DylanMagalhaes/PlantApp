package com.github.raziu75.plantapp.ui.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.github.raziu75.plantapp.model.APIResults


@Composable
fun PlantCard(result: APIResults) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Surface(
            modifier = Modifier
                .height(350.dp)
                .width(350.dp),
            shape = androidx.compose.material3.MaterialTheme.shapes.medium,
            shadowElevation = 2.dp,


        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                result.data[0].commonName?.let { Text(text = it, style = MaterialTheme.typography.h3) }

                Image(
                    modifier = Modifier
                        .size(100.dp),
                    painter = rememberAsyncImagePainter({result.data[0].imageUrl}),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Famille: ${result.data[0].family}",
                        style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                        )

                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )

                    Text(
                        text = "Genre: ${result.data[0].genus}",
                        style = androidx.compose.material3.MaterialTheme.typography.titleLarge
                        )
                }
            }
        }
    }
}


