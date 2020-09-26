package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model

data class UserRegisterRequest (
    val username: String,
    val name: String,
    val email: String,
    val address: String,
    val password: String,
    val passwordConfirmation: String
)