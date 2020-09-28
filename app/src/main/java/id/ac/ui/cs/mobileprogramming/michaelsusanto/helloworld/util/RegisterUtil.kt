package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserRegisterRequest
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.ValidationResponse
import java.util.regex.Matcher
import java.util.regex.Pattern

object RegisterUtil {

    private val EXISTING_USERNAMES: List<String> = listOf("admin", "manager")

    private val VALID_EMAIL_ADDRESS_REGEX: Pattern =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

    fun inputValidation(
        request: UserRegisterRequest
    ): ValidationResponse {
        if(!validateNonEmpty(request)) {
            return ValidationResponse(true, "Please fill all fields.")
        }

        if(!validateUsername(request.username)) {
            return ValidationResponse(true, "Username contains at least 4 characters.")
        }

        if(!validateUsernameExist(request.username)) {
            return ValidationResponse(true, "Username is already taken.")
        }

        if(!validateEmail(request.email)) {
            return ValidationResponse(true, "Email is not valid.")
        }

        if(!validatePassword(request.password)) {
            return ValidationResponse(true, "Password should contain at least 1 number and 8 characters.")
        }

        if(request.password != request.passwordConfirmation) {
            return ValidationResponse(true, "Password confirmation doesn't match.")
        }

        return ValidationResponse(false, "Successfully registered!")
    }

    private fun validateUsernameExist(username: String): Boolean {
        return username !in EXISTING_USERNAMES
    }

    private fun validatePassword(password: String): Boolean {
        return password.length >= 8 &&
                password.count { it.isDigit() } >= 1
    }

    private fun validateEmail(email: String): Boolean {
        val matcher: Matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email)
        return matcher.find()
    }

    private fun validateUsername(username: String): Boolean {
        return username.length >= 4
    }

    private fun validateNonEmpty(request: UserRegisterRequest): Boolean {
        return request.username.isNotEmpty() &&
                request.name.isNotEmpty() &&
                request.email.isNotEmpty() &&
                request.address.isNotEmpty() &&
                request.password.isNotEmpty()
    }
}