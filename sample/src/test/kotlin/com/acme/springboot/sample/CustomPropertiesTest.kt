package com.acme.springboot.sample

import com.acme.springboot.configure.CustomProperties
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CustomPropertiesTest {

    @Autowired(required = false)
    private var customProps: CustomProperties? = null

    @Autowired(required = false)
    private var myBean: String? = null

    @Test
    fun `Should have CustomProperties`() {
        assertThat(customProps).isNotNull
        customProps?.let { props ->
            assertThat(props.foo).isEqualTo("bar")
            assertThat(props.bar).isEqualTo(42)
            assertThat(props.baz).isTrue
        }
    }

    @Test
    fun `Should have myBean`() {
        assertThat(myBean).isEqualTo("I am a bean!")
    }
}
