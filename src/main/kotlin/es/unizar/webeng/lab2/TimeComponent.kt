package es.unizar.webeng.lab2

import java.time.LocalDateTime
import org.springframework.stereotype.Service

// DTO 
data class TimeDTO(val time: LocalDateTime)

// Interface
interface TimeProvider {
    fun now(): LocalDateTime
}

// Service implementation
@Service
class TimeService : TimeProvider {
    override fun now(): LocalDateTime = LocalDateTime.now()
}

// Extension function 
fun LocalDateTime.toDTO(): TimeDTO = TimeDTO(time = this)
