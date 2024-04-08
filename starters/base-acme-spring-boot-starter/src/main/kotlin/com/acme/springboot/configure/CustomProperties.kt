package com.acme.springboot.configure

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "acme")
data class CustomProperties(
    var foo: String,
    var bar: Int = 0,
    var baz: Boolean = false,
)
