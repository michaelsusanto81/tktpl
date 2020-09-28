package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui.auth.register

import org.junit.Test

import org.junit.Assert.*

class RegisterViewModelTest {

    private val viewModel = RegisterViewModel()

    @Test
    fun register() {
        val response = viewModel.register(
            username = "a",
            name = "name",
            email = "email@email.com",
            address = "address",
            password = "mypassword123",
            passwordConfirmation = "mypassword123"
        )
        assertTrue(response.isError)
    }
}