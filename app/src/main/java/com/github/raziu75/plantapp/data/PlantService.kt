package com.github.raziu75.plantapp.data

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//Base URL
private val baseURL = "https://trefle.io/api/v1/plants/"

//Ajouter paremetre pour retrofit
private var scalarsConverterFactory = ScalarsConverterFactory.create()

//Construction retrofit
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(scalarsConverterFactory)
    .baseUrl(baseURL)
    .build()

//Interface d'appel
interface PlantService {
    @GET("search")
    suspend fun getPlant(
        @Query("token") token: String = apiKey,
        @Query("q") q: String,
    ): String
}

//Objet d'appel

object PlantAPI {
    val service: PlantService by lazy {
        retrofit.create(PlantService::class.java)
    }
}

