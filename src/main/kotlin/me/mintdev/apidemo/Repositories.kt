package me.mintdev.apidemo

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User,Long> {
    fun findAllByOrderByCreatedAtDesc(): Iterable<User>

    fun findByUsername(username: String): Optional<User>
}