package com.example.takadakenshidensetsu.repository

import com.example.takadakenshidensetsu.model.DensetsuResult
import retrofit2.http.GET

interface DensetsuApi {
    @GET(".")
    suspend fun getDensetsu(): DensetsuResult
}