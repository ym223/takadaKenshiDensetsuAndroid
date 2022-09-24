package com.example.takadakenshidensetsu.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "densetsu_table")
data class DensetsuResult
    (
    @PrimaryKey val No: Int,
    val text: String
)
