package com.acme.springboot.configure

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource

@AutoConfiguration
@PropertySource("classpath:/acme.properties")
@EnableConfigurationProperties(CustomProperties::class)
class CustomAutoConfiguration(
    private val props: CustomProperties
) {

    private val log = org.slf4j.LoggerFactory.getLogger(CustomAutoConfiguration::class.java)

    @Value("\${acme.foo}")
    private lateinit var foo: String

    @Bean
    fun myBean(): String {
        return "I am a bean!"
    }

    @PostConstruct
    fun postConstruct() {
        log.info("CustomAutoConfiguration initialized. foo={}", foo)
        log.info("CustomProperties: {}", props)
    }
}