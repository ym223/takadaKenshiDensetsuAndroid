package com.example.takadakenshidensetsu.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.takadakenshidensetsu.model.Densetsu

@Dao
interface DensetsuDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDensetsu(densetsu: Densetsu)

    @Query("select * from densetsu_table")
    fun getDensetsuAll(): List<Densetsu>
}