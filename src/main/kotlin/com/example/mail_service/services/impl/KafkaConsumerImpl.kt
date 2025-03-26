package com.example.mail_service.services.impl

import com.example.mail_service.dto.KafkaMessageDto
import com.example.mail_service.services.KafkaConsumer
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class KafkaConsumerImpl : KafkaConsumer {
    @KafkaListener(
        topics = ["email-message-topic"],
        groupId = "1"
    )
    override fun listen(message: KafkaMessageDto) {
        println("email: ${message.email} \n url: ${message.url}");
    }
}