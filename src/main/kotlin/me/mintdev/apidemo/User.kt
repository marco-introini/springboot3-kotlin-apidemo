package me.mintdev.apidemo

import java.time.LocalDateTime

data class User(
    var username: String,
    var email: String,
    var password: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
)
