package com.example.datas.data.clients

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.example.domains.domain.repository.MutPingRepository
import com.plcoding.MutPingMutation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ApolloMutPingClient @Inject constructor(
    private val apolloClient: ApolloClient
) : MutPingRepository {

    override suspend fun getPing(): Flow<String> {

        return flow {
            try {
                val response = apolloClient.mutation(MutPingMutation()).execute()
                val pingMessage = response.data?.ping

                val result = if (pingMessage != null) {
                    "Ping result: $pingMessage"
                } else {
                    "Mutation executed, but no ping message received."
                }

                emit(result)
            } catch (e: ApolloException) {
                emit("Mutation failed: ${e.message}")
            }
        }.map { it }
    }
}