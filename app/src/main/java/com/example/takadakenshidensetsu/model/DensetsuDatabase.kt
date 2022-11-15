package com.example.takadakenshidensetsu.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DensetsuResult::class], version = 1, exportSchema = false)
abstract class DensetsuDatabase : RoomDatabase() {
    abstract fun densetsuDao(): DensetsuDao

}