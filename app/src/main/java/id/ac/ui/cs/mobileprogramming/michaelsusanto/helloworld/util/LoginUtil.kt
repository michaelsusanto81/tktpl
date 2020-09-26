package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.User
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserLoginRequest

object LoginUtil {

    private val DUMMY_USER: User = User(
        id = 1,
        username = "dummy",
        name = "Dummy User",
        email = "dummy@email.com",
        address = "Jl. Dummy Raya No.1"
    )

    private val DUMMY_USER_PASSWORD: String = "dummy12345"

    fun inputValidation(
        request: UserLoginRequest
    ): Boolean {
        if(!validateNonEmpty(request)) {
            return false
        }

        if(!validateUsername(request.username)) {
            return false
        }

        if(!validatePassword(request.password)) {
            return false
        }

        return true
    }

    private fun validatePassword(password: String): Boolean {
        return password == DUMMY_USER_PASSWORD
    }

    private fun validateUsername(username: String): Boolean {
        return username == DUMMY_USER.username
    }

    private fun validateNonEmpty(request: UserLoginRequest): Boolean {
        return request.username.isNotEmpty() &&
                request.password.isNotEmpty()
    }
}