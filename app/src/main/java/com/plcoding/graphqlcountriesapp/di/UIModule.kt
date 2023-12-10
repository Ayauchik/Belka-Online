package com.plcoding.graphqlcountriesapp.di

import com.example.domains.domain.repository.GameRepository
import com.example.domains.domain.use_case.GameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UIModule {

    @Provides
    @Singleton
    fun provideGameUseCase(gameRepository: GameRepository): GameUseCase{
        return GameUseCase(gameRepository)
    }
}