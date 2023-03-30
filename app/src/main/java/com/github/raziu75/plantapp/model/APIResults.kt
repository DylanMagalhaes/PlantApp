package com.github.raziu75.plantapp.model

import com.google.gson.annotations.SerializedName

data class APIResults(
    @SerializedName("data") val data: List<ApiResponse>
){
    data class ApiResponse(
        @SerializedName("common_name") val commonName: String?,
        @SerializedName("scientific_name") val scientificName: String,
        @SerializedName("family") val family: String?,
        @SerializedName("image_url") val imageUrl: String?,
        @SerializedName("genus") val genus: String,
    )
}

