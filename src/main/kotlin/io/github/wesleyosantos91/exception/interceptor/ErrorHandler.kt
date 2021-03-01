package io.github.wesleyosantos91.exception.interceptor

import io.micronaut.aop.Around
import io.micronaut.context.annotation.Type
import kotlin.annotation.AnnotationTarget.*

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(CLASS, FILE, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER)
@Around
@Type(ExceptionHandlerInterceptor::class)
annotation class ErrorHandler()