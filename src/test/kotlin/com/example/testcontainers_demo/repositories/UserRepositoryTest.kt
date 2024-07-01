package com.example.testcontainers_demo.repositories

import com.example.testcontainers_demo.entities.UserEntity
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import kotlin.test.Test


@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@ActiveProfiles("test")
class UserRepositoryTest {
    companion object {
        @JvmStatic
        @Container
        @ServiceConnection
        val db = MySQLContainer("mysql:8.4.0")

        @JvmStatic
        @BeforeAll
        fun startContainer() {
            db.start()
        }

        @JvmStatic
        @AfterAll
        fun stopContainer() {
            db.stop()
        }

//       Useful only for versions before Spring 3.1.0
//        @JvmStatic
//        @DynamicPropertySource
//        fun registerContainer(registry: DynamicPropertyRegistry) {
//            registry.add("spring.datasource.url", db::getJdbcUrl)
//            registry.add("spring.datasource.username", db::getUsername)
//            registry.add("spring.datasource.password", db::getPassword)
//        }

    }

    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun addRemove() {
        val u = UserEntity(name = "Christina", age = 22)
        userRepository.save(u)

        userRepository.findByIdOrNull(u.id) shouldBe u
    }


}