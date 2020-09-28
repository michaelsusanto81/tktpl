package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui.auth.login

import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserLoginRequest
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.ValidationResponse
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util.LoginUtil

class LoginViewModel(): ViewModel() {

    fun login(
        username: String,
        password: String
    ): ValidationResponse {
        val request = UserLoginRequest(username, password)
        return LoginUtil.inputValidation(request)
    }
}