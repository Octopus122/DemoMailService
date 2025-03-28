package com.example.mail_service.services.impl

import com.example.mail_service.dto.KafkaMessageDto
import com.example.mail_service.services.BasicMailService
import com.example.mail_service.services.KafkaConsumer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class KafkaConsumerImpl(
    private val mailService: BasicMailService
) : KafkaConsumer {
    @KafkaListener(
        topics = ["email-message-topic"],
        groupId = "1"
    )
    override suspend fun listen(message: KafkaMessageDto): Unit = withContext(Dispatchers.IO){
        println("email: ${message.email} \n url: ${message.url}")
        launch {
            println("Start sending message to ${message.email}")
            mailService.sendConfirmationEmail(message.email, message.url)
            println("Successfully sent message to ${message.email}")
        }

    }
}