package com.threed.supply.features.login.domain

import com.spotify.mobius.Next
import com.spotify.mobius.Next.dispatch
import com.spotify.mobius.Next.next
import com.threed.supply.features.login.domain.LoginEffect.*
import com.threed.supply.features.login.domain.LoginEvent.*
import java.util.regex.Pattern

data class LoginModel(
    val email: String = "",
    val password: String = "",
    val loginEnabled: Boolean = false,
    val loggingIn: Boolean = false,
    val errorMessage: String = ""
)

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    data class LoginRequested(val email: String, val password: String) : LoginEvent()
    data class LoginSucceeded(val credentials: String) : LoginEvent()
    data class LoginFailed(val error: String) : LoginEvent()
    object SaveCredentialsCompleted : LoginEvent()
    object SignUpPressed : LoginEvent()
    data class ResetPasswordRequested(val email: String) : LoginEvent()
}

sealed class LoginEffect {
    data class Login(val email: String, val password: String) : LoginEffect()
    object NavigateToSignUp : LoginEffect()
    object NavigateToHome : LoginEffect()
    data class ResetPassword(val email: String) : LoginEffect()
    data class SaveCredentials(val credentials: String) : LoginEffect()
}

fun update(model: LoginModel, event: LoginEvent): Next<LoginModel, LoginEffect> =
    when (event) {
        is EmailChanged -> next(
            model.copy(
                email = event.email,
                loginEnabled = isValidLogin(event.email, model.password)
            )
        )
        is PasswordChanged -> next(
            model.copy(
                password = event.password,
                loginEnabled = isValidLogin(model.email, event.password)
            )
        )
        is LoginRequested -> next(
            model.copy(loggingIn = true, errorMessage = ""),
            setOf(Login(model.email, model.password))
        )
        is LoginSucceeded -> dispatch(setOf(SaveCredentials(event.credentials)))
        is LoginFailed -> next(model.copy(loggingIn = false, errorMessage = event.error))
        SaveCredentialsCompleted -> dispatch(setOf(NavigateToHome))
        SignUpPressed -> dispatch(setOf(NavigateToSignUp))
        is ResetPasswordRequested -> dispatch(setOf(ResetPassword(event.email))) //TODO(mariana) verify email is not empty
    }

private fun isValidLogin(email: String, password: String): Boolean =
    email.isValidEmail && password.isValidPassword

private val String.isValidEmail: Boolean
    get() = this.isNotEmpty() && Pattern.compile(".+@.+\\.[a-z]+").matcher(this).matches()
private val String.isValidPassword: Boolean
    get() = this.isNotEmpty() && this.length >= 8 && this.length <= 20
