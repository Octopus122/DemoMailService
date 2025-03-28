package com.example.mail_service.services

interface BasicMailService {
    fun sendConfirmationEmail(toAddress: String, url: String)
}