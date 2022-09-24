package com.example.takadakenshidensetsu.network

import com.example.takadakenshidensetsu.model.DensetsuResult
import retrofit2.http.GET

interface DensetsuApi {
    @GET(".")
    suspend fun getDensetsu(): DensetsuResult
}