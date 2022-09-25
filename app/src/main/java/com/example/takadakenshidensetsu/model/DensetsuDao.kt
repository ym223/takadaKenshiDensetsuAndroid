package com.example.takadakenshidensetsu.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DensetsuDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDensetsu(densetsu: DensetsuResult)

    @Query("select * from densetsu_table")
    fun getDensetsuAll(): List<DensetsuResult>
}