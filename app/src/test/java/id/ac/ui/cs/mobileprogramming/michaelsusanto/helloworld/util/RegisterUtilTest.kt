package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserRegisterRequest
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class RegisterUtilTest {

    private lateinit var request: UserRegisterRequest

    @Test
    fun `empty username returns false`() {
        request = UserRegisterRequest(
            username = "",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `existing username returns false`() {
        request = UserRegisterRequest(
            username = "admin",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `username length less than 4 returns false`() {
        request = UserRegisterRequest(
            username = "mic",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `username length greater than equals 4 returns true`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response)
    }

    @Test
    fun `empty name returns false`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `non-empty name returns true`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response)
    }

    @Test
    fun `empty email returns false`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `non-empty email but not an email's pattern returns false`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "abc",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)

        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "abc@ui.ac.idabc@ui.ac.id",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val responseDuplicatedEmail = RegisterUtil.inputValidation(request)
        assertFalse(responseDuplicatedEmail)
    }

    @Test
    fun `non-empty email and is a valid email returns true`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "abc@ui.ac.id",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response)
    }

    @Test
    fun `empty address returns false`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `non-empty address returns true`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response)
    }

    @Test
    fun `empty password returns false`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `non-empty password but less than 8 characters returns false`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "pass",
            passwordConfirmation = "pass"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `non-empty password with greater than equal 8 characters but doesn't contain number returns false`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "passwordhaha",
            passwordConfirmation = "passwordhaha"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `non-empty password with greater than equal 8 characters and contains number returns true`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response)
    }

    @Test
    fun `password confirmation doesn't match password returns false`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password1234"
        )
        val response = RegisterUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `password confirmation matches password returns true`() {
        request = UserRegisterRequest(
            username = "michael",
            name = "Michael Susanto",
            email = "michaelsusanto32@gmail.com",
            address = "Jl. Android Test No.1, Jakarta, Indonesia",
            password = "password123",
            passwordConfirmation = "password123"
        )
        val response = RegisterUtil.inputValidation(request)
        assertTrue(response)
    }
}