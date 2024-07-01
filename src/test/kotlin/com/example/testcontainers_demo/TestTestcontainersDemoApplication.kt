package com.example.testcontainers_demo

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<TestcontainersDemoApplication>().with(TestcontainersConfiguration::class).run(*args)
}
