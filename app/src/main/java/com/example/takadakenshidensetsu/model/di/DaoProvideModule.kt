package com.example.takadakenshidensetsu.model.di

import android.content.Context
import androidx.room.Room
import com.example.takadakenshidensetsu.model.db.DensetsuDao
import com.example.takadakenshidensetsu.model.db.DensetsuDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoProvideModule {

    @Singleton
    @Provides
    fun createDensetsuDb(@ApplicationContext context: Context) : DensetsuDatabase {
        return Room.databaseBuilder(context, DensetsuDatabase::class.java, "densetsu")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun densetsuDao(db: DensetsuDatabase): DensetsuDao = db.densetsuDao()
}