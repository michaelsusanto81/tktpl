package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.User
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserLoginRequest
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.ValidationResponse

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
    ): ValidationResponse {
        if(!validateNonEmpty(request)) {
            return ValidationResponse(true, "Please fill all fields.")
        }

        if(!validateUsername(request.username)) {
            return ValidationResponse(true, "Username doesn't exist.")
        }

        if(!validatePassword(request.password)) {
            return ValidationResponse(true, "Password doesn't match.")
        }

        return ValidationResponse(false, "Logged in!")
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