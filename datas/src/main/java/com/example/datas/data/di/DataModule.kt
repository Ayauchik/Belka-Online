package com.example.datas.data.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.ws.GraphQLWsProtocol
import com.apollographql.apollo3.network.ws.WebSocketNetworkTransport
import com.example.datas.data.clients.ApolloMutPingClient
import com.example.datas.data.clients.ApolloSubsPingClient
import com.example.datas.data.clients.AppolloGameClient
import com.example.datas.data.clients.AppolloPingClient
import com.example.domains.domain.repository.GameRepository
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
object DataModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("http://172.25.80.1:8081/graphql")
            .subscriptionNetworkTransport(
                WebSocketNetworkTransport.Builder()
                    .protocol(GraphQLWsProtocol.Factory())
                    .serverUrl("ws://172.25.80.1:8081/graphql")
                    .build()
            )
            .build()
    }

    @Provides
    @Singleton
    fun providePingRepository(apolloClient: ApolloClient): PingRepository {
        return AppolloPingClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideSubsPingRepository(apolloClient: ApolloClient): SubsPingRepository {
        return ApolloSubsPingClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideMutPingRepository(apolloClient: ApolloClient): MutPingRepository {
        return ApolloMutPingClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGameRepository(apolloClient: ApolloClient): GameRepository{
        return AppolloGameClient(apolloClient)
    }

}
