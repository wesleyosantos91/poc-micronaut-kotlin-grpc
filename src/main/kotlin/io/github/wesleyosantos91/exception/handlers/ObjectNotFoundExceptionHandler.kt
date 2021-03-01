package io.github.wesleyosantos91.exception.handlers

import io.github.wesleyosantos91.exception.core.ObjectNotFoundException
import io.github.wesleyosantos91.exception.interceptor.ExceptionHandler
import io.github.wesleyosantos91.exception.interceptor.ExceptionHandler.StatusWithDetails
import io.grpc.Status
import javax.inject.Singleton

@Singleton
class ObjectNotFoundExceptionHandler : ExceptionHandler<ObjectNotFoundException> {

    override fun handle(e: ObjectNotFoundException): StatusWithDetails {
        return StatusWithDetails(Status.NOT_FOUND
            .withDescription(e.message)
            .withCause(e))
    }

    override fun supports(e: Exception): Boolean {
        return e is ObjectNotFoundException
    }
}