package com.example.takadakenshidensetsu.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.takadakenshidensetsu.model.Densetsu

@Database(entities = [Densetsu::class], version = 1, exportSchema = false)
abstract class DensetsuDatabase : RoomDatabase() {
    abstract fun densetsuDao(): DensetsuDao

}