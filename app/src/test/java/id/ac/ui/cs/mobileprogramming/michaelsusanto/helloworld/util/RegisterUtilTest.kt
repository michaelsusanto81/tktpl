package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserRegisterRequest
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class RegisterUtilTest {

    private lateinit var request: UserRegisterRequest

    @Test
    fun `empty username returns error`() {
        request = UserRegisterRequest(
            username = "",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `existing username returns error`() {
        request = UserRegisterRequest(
            username = "admin",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `username length less than 4 returns error`() {
        request = UserRegisterRequest(
            username = "mic",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `username length greater than equals 4 doesn't return error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response.isError)
    }

    @Test
    fun `empty name returns error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `non-empty name doesn't return error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response.isError)
    }

    @Test
    fun `empty email returns error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `non-empty email but not an email's pattern returns error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "abc",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)

        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "abc@ui.ac.idabc@ui.ac.id",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val responseDuplicatedEmail = RegisterUtil.inputValidation(request)
        assertTrue(responseDuplicatedEmail.isError)
    }

    @Test
    fun `non-empty email and is a valid email doesn't return error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "abc@ui.ac.id",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response.isError)
    }

    @Test
    fun `empty address returns error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `non-empty address doesn't return error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response.isError)
    }

    @Test
    fun `empty password returns error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `non-empty password but less than 8 characters returns error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "pass",
            passwordConfirmation = "pass"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `non-empty password with greater than equal 8 characters but doesn't contain number returns error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "passwordhaha",
            passwordConfirmation = "passwordhaha"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `non-empty password with greater than equal 8 characters and contains number doesn't return error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response.isError)
    }

    @Test
    fun `password confirmation doesn't match password returns error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password1234"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `password confirmation matches password doesn't return error`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response.isError)
    }
}