package com.example.domains.domain.use_case

import com.example.domains.domain.repository.PingRepository

class GetPingUseCase(
    private val pingRepository: PingRepository
) {
    suspend fun execute() : String {
        return pingRepository.getPing()
    }
}