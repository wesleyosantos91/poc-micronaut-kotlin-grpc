package io.github.wesleyosantos91.utils

import com.google.protobuf.Timestamp
import java.time.ZoneId
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalDate
import java.time.ZoneOffset

class DateUtils {

    fun fromLocalDate(localDate: LocalDate): Timestamp? {
        val instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC)
        return Timestamp.newBuilder()
            .setSeconds(instant.epochSecond)
            .setNanos(instant.nano)
            .build()
    }

    fun toLocalDate(timestamp: Timestamp): LocalDate? {
        return LocalDateTime.ofInstant(
            Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos().toLong()),
            ZoneId.of("UTC")
        )
            .toLocalDate()
    }
}