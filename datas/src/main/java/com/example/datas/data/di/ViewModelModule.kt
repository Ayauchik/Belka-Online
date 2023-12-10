package com.example.datas.data.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
/*
    @Provides
    @ViewModelScoped
    fun providePingViewModel(getPingUseCase: GetPingUseCase): PingViewModel {
        return PingViewModel(getPingUseCase)
    }*/
}
