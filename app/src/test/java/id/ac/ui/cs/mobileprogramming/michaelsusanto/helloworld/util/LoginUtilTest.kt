package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserLoginRequest
import org.junit.Test

import org.junit.Assert.*

class LoginUtilTest {

    private lateinit var request: UserLoginRequest

    @Test
    fun `empty username returns false`() {
        request = UserLoginRequest(
            username = "",
            password = "dummy12345"
        )
        val response = LoginUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `empty password returns false`() {
        request = UserLoginRequest(
            username = "dummy",
            password = ""
        )
        val response = LoginUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `username doesn't exist returns false`() {
        request = UserLoginRequest(
            username = "dummyDoesNotExist",
            password = "dummy12345"
        )
        val response = LoginUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `username exists wrong password returns false`() {
        request = UserLoginRequest(
            username = "dummy",
            password = "dummy12345asd"
        )
        val response = LoginUtil.inputValidation(request)
        assertFalse(response)
    }

    @Test
    fun `all credentials match returns true`() {
        request = UserLoginRequest(
            username = "dummy",
            password = "dummy12345"
        )
        val response = LoginUtil.inputValidation(request)
        assertTrue(response)
    }
}