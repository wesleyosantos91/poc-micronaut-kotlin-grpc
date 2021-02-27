package io.github.wesleyosantos91

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("io.github.wesleyosantos91")
		.start()
}

