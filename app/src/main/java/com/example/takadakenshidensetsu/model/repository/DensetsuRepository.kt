package com.example.takadakenshidensetsu.model.repository

import com.example.takadakenshidensetsu.model.db.DensetsuDao
import com.example.takadakenshidensetsu.model.DensetsuResult
import com.example.takadakenshidensetsu.model.network.DensetsuApi
import javax.inject.Inject

interface DensetsuRepository {
    suspend fun getDensetsu(): DensetsuResult

    suspend fun insertDensetsu(densetsu: DensetsuResult)

    suspend fun getDensetsuAll(): List<DensetsuResult>
}

class DensetsuRepositoryImpl @Inject constructor(
    private val densetsuApi: DensetsuApi,
    private val densetsuDao: DensetsuDao
) : DensetsuRepository {

    override suspend fun getDensetsu() = densetsuApi.getDensetsu()

    override suspend fun insertDensetsu(densetsu: DensetsuResult) =
        densetsuDao.insertDensetsu(densetsu = densetsu)

    override suspend fun getDensetsuAll(): List<DensetsuResult> = densetsuDao.getDensetsuAll()

}