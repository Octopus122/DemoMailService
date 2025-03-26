package com.example.mail_service.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter
import org.springframework.kafka.support.converter.JsonMessageConverter


//@Configuration
//class DeserializerConfig {
//    @Bean
//    fun jsonMessageConverter(): JsonMessageConverter {
//        return ByteArrayJsonMessageConverter()
//    }
//}