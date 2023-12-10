package com.example.datas.data.clients

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.plcoding.SubsPingSubscription
import com.example.domains.domain.repository.SubsPingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ApolloSubsPingClient(
    private val apolloClient: ApolloClient
): SubsPingRepository {
    override suspend fun getPing(): Flow<String> {

        return apolloClient.subscription(SubsPingSubscription())
            .toFlow()
            .map { response ->
                // Extract relevant data from the response and return it as a string
                val pongNumber = response.data?.ping ?: 0
                "$pongNumber"
            }
    }

}