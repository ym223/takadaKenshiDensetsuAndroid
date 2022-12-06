package com.example.takadakenshidensetsu.model.network

import com.example.takadakenshidensetsu.model.Densetsu
import retrofit2.http.GET
import retrofit2.http.Headers

interface DensetsuApi {
    @Headers("User-Agent: TakadaKenshiDensetsu")
    @GET(".")
    suspend fun getDensetsu(): Densetsu
}