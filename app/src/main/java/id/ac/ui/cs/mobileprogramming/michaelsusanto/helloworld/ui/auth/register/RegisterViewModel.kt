package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui.auth.register

import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.UserRegisterRequest
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.ValidationResponse
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util.RegisterUtil

class RegisterViewModel(): ViewModel() {

    fun register(
        username: String,
        name: String,
        email: String,
        address: String,
        password: String,
        passwordConfirmation: String
    ): ValidationResponse {
        val request = UserRegisterRequest(username, name, email, address, password, passwordConfirmation)
        return RegisterUtil.inputValidation(request)
    }
}