package com.example.takadakenshidensetsu.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DensetsuResult::class], version = 1, exportSchema = false)
abstract class DensetsuDatabase : RoomDatabase() {
    abstract fun densetsuDao(): DensetsuDao

    companion object {
        private var INSTANCE: DensetsuDatabase? = null

        fun getInstance(context: Context): DensetsuDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DensetsuDatabase::class.java,
                    "densetsu"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}