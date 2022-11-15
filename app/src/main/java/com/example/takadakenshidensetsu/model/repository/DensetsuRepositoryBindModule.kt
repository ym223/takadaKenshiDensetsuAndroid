package com.example.takadakenshidensetsu.model.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DensetsuRepositoryBindModule {

    @Singleton
    @Binds
    abstract fun densetsuRepository(densetsuRepositoryImpl: DensetsuRepositoryImpl) : DensetsuRepository
}