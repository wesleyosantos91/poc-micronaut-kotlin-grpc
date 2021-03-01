package io.github.wesleyosantos91.utils

import org.testcontainers.containers.MySQLContainer

class TestDbContainer : MySQLContainer<TestDbContainer>() {
    companion object {
        private lateinit var instance: TestDbContainer

        fun start() {
            if (!Companion::instance.isInitialized) {
                instance = TestDbContainer()
                instance.dockerImageName = "mysql:8.0.21"
                instance.start()

                System.setProperty("datasources.default.url", instance.jdbcUrl)
                System.setProperty("datasources.default.username", instance.username)
                System.setProperty("datasources.default.password", instance.password)
            }
        }

        fun stop() {
            if (Companion::instance.isInitialized) {
                instance.stop()
            }
        }
    }
}