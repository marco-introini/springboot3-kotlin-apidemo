package me.mintdev.apidemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApidemoApplication

fun main(args: Array<String>) {
	runApplication<ApidemoApplication>(*args)
}
