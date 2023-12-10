package com.example.datas.data.clients

import com.apollographql.apollo3.ApolloClient
import com.plcoding.PingQuery
import com.example.domains.domain.repository.PingRepository

class AppolloPingClient(
    private val apolloClient: ApolloClient
) : PingRepository {
     override suspend fun getPing(): String {
        return apolloClient.query(PingQuery())
            .execute()
            .data
            ?.ping
            .orEmpty()
    }
    /*override suspend fun getPing(): Flow<String> {
        return apolloClient.subscription(SubsPingSubscription())
            .toFlow()
            .map { response ->
                // Extract relevant data from the response and return it as a string
                val pongNumber = response.data?.ping ?: 0
                "Pong-$pongNumber"
            }
    }*/
}