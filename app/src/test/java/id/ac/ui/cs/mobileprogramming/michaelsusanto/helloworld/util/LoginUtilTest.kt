package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserLoginRequest
import org.junit.Test

import org.junit.Assert.*

class LoginUtilTest {

    private lateinit var request: UserLoginRequest

    @Test
    fun `empty username returns error`() {
        request = UserLoginRequest(
            username = "",
            password = "dummy12345"
        )
        val response = LoginUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `empty password returns error`() {
        request = UserLoginRequest(
            username = "dummy",
            password = ""
        )
        val response = LoginUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `username doesn't exist returns error`() {
        request = UserLoginRequest(
            username = "dummyDoesNotExist",
            password = "dummy12345"
        )
        val response = LoginUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `username exists wrong password returns error`() {
        request = UserLoginRequest(
            username = "dummy",
            password = "dummy12345asd"
        )
        val response = LoginUtil.inputValidation(request)
        assertTrue(response.isError)
    }

    @Test
    fun `all credentials match doesn't return error`() {
        request = UserLoginRequest(
            username = "dummy",
            password = "dummy12345"
        )
        val response = LoginUtil.inputValidation(request)
        assertFalse(response.isError)
    }
}