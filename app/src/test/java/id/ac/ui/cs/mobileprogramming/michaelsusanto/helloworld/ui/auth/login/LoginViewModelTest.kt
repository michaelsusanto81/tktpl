package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui.auth.login

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserLoginRequest
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.ValidationResponse
import org.junit.Test

import org.junit.Assert.*

class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @Test
    fun login() {
        val request = viewModel.login("testUsername", "testpassword123")
        assertTrue(request.isError)
    }
}