package com.example.takadakenshidensetsu.repository

import com.example.takadakenshidensetsu.model.DensetsuDao
import com.example.takadakenshidensetsu.model.DensetsuResult
import com.example.takadakenshidensetsu.network.DensetsuApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DensetsuRepository(private val densetsuDao: DensetsuDao) {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://tools.ic731.net/api/kenshi/takada.php/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val DensetsuService = retrofit.create(DensetsuApi::class.java)

    suspend fun getDensetsu() = DensetsuService.getDensetsu()

    suspend fun insertDensetsu(densetsu: DensetsuResult) = densetsuDao.insertDensetsu(densetsu)

    suspend fun getDensetsuAll(): List<DensetsuResult> = densetsuDao.getDensetsuAll()
}