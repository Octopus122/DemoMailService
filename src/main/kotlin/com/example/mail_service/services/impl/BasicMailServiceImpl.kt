package com.example.mail_service.services.impl

import com.example.mail_service.services.BasicMailService
import jakarta.mail.internet.MimeMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service


@Service
class BasicMailServiceImpl(
    private val mailSender: JavaMailSender
): BasicMailService {
    @Value("\${spring.mail.username}")
    private val fromAddress: String = ""

    override fun sendConfirmationEmail(toAddress: String, url: String) {
        val message: MimeMessage = mailSender.createMimeMessage()

        val helper = MimeMessageHelper(message, true)
        println("очта отправления: $fromAddress")
        helper.setFrom(fromAddress)
        helper.setTo(toAddress)
        helper.setSubject("Подтверждение почты")
        helper.setText("Для подтверждения почты перейдите по сслыке: $url")
        mailSender.send(message);
    }
}