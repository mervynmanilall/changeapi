data class LoginRequestModel(
    val username: String,
    val password: String
)

data class LoginResponse(
    val token: String
)