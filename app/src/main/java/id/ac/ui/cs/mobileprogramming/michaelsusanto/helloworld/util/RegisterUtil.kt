package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserRegisterRequest
import java.util.regex.Matcher
import java.util.regex.Pattern

object RegisterUtil {

    private val EXISTING_USERNAMES: List<String> = listOf("admin", "manager")

    private val VALID_EMAIL_ADDRESS_REGEX: Pattern =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

    fun inputValidation(
        request: UserRegisterRequest
    ): Boolean {
        if(!validateNonEmpty(request)) {
            return false
        }

        if(!validateUsername(request.username)) {
            return false
        }

        if(!validateEmail(request.email)) {
            return false
        }

        if(!validatePassword(request.password)) {
            return false
        }

        if(request.password != request.passwordConfirmation) {
            return false
        }

        return true
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
        return username.length >= 4 &&
                username !in EXISTING_USERNAMES
    }

    private fun validateNonEmpty(request: UserRegisterRequest): Boolean {
        return request.username.isNotEmpty() &&
                request.name.isNotEmpty() &&
                request.email.isNotEmpty() &&
                request.address.isNotEmpty() &&
                request.password.isNotEmpty()
    }
}