package me.mintdev.apidemo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api/v1/users")
class UserController {
    val users = mutableListOf(User(username = "user",
        email = "test@test.com",
        password = "password"))

    @GetMapping
    fun users() = users

    @GetMapping("/{username}")
    fun users(@PathVariable username:String) =
        users.find { user -> user.username == username } ?: ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping
    fun newUser(@RequestBody user: User): User {
        users.add(user);
        return user;
    }

    @PutMapping("/{username}")
    fun updateUser(@RequestBody user:User,@PathVariable username:String): User {
        val existingUser = users.find { it.username == username } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        existingUser.username = user.username
        existingUser.email = user.email
        existingUser.password = user.password
        return existingUser
    }

    @DeleteMapping("/{username}")
    fun deleteUser(@PathVariable username:String) {
        users.removeIf { user -> user.username == username }
        throw ResponseStatusException(HttpStatus.NO_CONTENT)
    }
}