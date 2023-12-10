package com.plcoding.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.example.datas.data.clients.ApolloMutPingClient
import com.example.datas.data.clients.ApolloSubsPingClient
import com.example.datas.data.clients.AppolloPingClient
import com.example.domains.domain.use_case.GetMutPingUseCase
import com.example.domains.domain.use_case.GetPingUseCase
import com.example.domains.domain.use_case.GetSubsPingUseCase
import com.example.domains.domain.repository.MutPingRepository
import com.example.domains.domain.repository.PingRepository
import com.example.domains.domain.repository.SubsPingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetPingUseCase(pingRepository: PingRepository): GetPingUseCase {
        return GetPingUseCase(pingRepository)
    }

    @Provides
    @Singleton
    fun provideGetSubsPingUseCase(subsPingRepository: SubsPingRepository): GetSubsPingUseCase {
        return GetSubsPingUseCase(subsPingRepository)
    }


    @Provides
    @Singleton
    fun provideGetMutPingUseCase(mutPingRepository: MutPingRepository): GetMutPingUseCase {
        return GetMutPingUseCase(mutPingRepository)
    }
}