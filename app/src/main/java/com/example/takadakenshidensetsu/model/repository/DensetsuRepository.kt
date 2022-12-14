package com.example.takadakenshidensetsu.model.repository

import com.example.takadakenshidensetsu.model.db.DensetsuDao
import com.example.takadakenshidensetsu.model.Densetsu
import com.example.takadakenshidensetsu.model.network.DensetsuApi
import javax.inject.Inject

interface DensetsuRepository {
    suspend fun getDensetsu(): Densetsu

    suspend fun insertDensetsu(densetsu: Densetsu)

    suspend fun getDensetsuAll(): List<Densetsu>
}

class DensetsuRepositoryImpl @Inject constructor(
    private val densetsuApi: DensetsuApi,
    private val densetsuDao: DensetsuDao
) : DensetsuRepository {

    override suspend fun getDensetsu() = densetsuApi.getDensetsu()

    override suspend fun insertDensetsu(densetsu: Densetsu) =
        densetsuDao.insertDensetsu(densetsu = densetsu)

    override suspend fun getDensetsuAll(): List<Densetsu> = densetsuDao.getDensetsuAll()

}