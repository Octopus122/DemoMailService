package com.example.mail_service.services

import com.example.mail_service.dto.KafkaMessageDto

interface KafkaConsumer {
    suspend fun listen (message: KafkaMessageDto)
}