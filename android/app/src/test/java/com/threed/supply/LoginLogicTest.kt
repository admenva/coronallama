package com.threed.supply

import com.spotify.mobius.test.NextMatchers.hasEffects
import com.spotify.mobius.test.NextMatchers.hasModel
import com.spotify.mobius.test.UpdateSpec
import com.spotify.mobius.test.UpdateSpec.assertThatNext
import com.threed.supply.features.login.domain.LoginEffect
import com.threed.supply.features.login.domain.LoginEffect.*
import com.threed.supply.features.login.domain.LoginEvent
import com.threed.supply.features.login.domain.LoginEvent.*
import com.threed.supply.features.login.domain.LoginModel
import com.threed.supply.features.login.domain.update
import org.junit.Before
import org.junit.Test

class LoginLogicTest {

    private lateinit var updateSpec: UpdateSpec<LoginModel, LoginEvent, LoginEffect>

    @Before
    fun setUp() {
        updateSpec = UpdateSpec(::update)
    }

    @Test
    fun updateEmail_whenEmailChanged() {
        val model = LoginModel()
        updateSpec
            .given(model)
            .whenEvent(EmailChanged(email = "test"))
            .then(assertThatNext(hasModel(model.copy(email = "test"))))
    }

    @Test
    fun updatePassword_whenPasswordChanged() {
        val model = LoginModel()
        updateSpec
            .given(model)
            .whenEvent(PasswordChanged(password = "1234"))
            .then(assertThatNext(hasModel(model.copy(password = "1234"))))
    }

    @Test
    fun enableLogin_whenEmailChanged_andValidEmailAndPassword() {
        val model = LoginModel(password = "12345678")
        updateSpec
            .given(model)
            .whenEvent(EmailChanged(email = "test@gmail.com"))
            .then(
                assertThatNext(
                    hasModel(model.copy(email = "test@gmail.com", loginEnabled = true))
                )
            )
    }

    @Test
    fun enableLogin_whenPasswordChanged_andValidEmailAndPassword() {
        val model = LoginModel(email = "test@gmail.com")
        updateSpec
            .given(model)
            .whenEvent(PasswordChanged(password = "12345678"))
            .then(
                assertThatNext(
                    hasModel(model.copy(password = "12345678", loginEnabled = true))
                )
            )
    }

    @Test
    fun disableLogin_whenInvalidEmail() {
        val model = LoginModel(email = "test@gmail.com", loginEnabled = true)
        updateSpec
            .given(model)
            .whenEvent(EmailChanged(email = "test@gmail.com"))
            .then(
                assertThatNext(
                    hasModel(model.copy(email = "test@gmail.com", loginEnabled = false))
                )
            )
    }

    @Test
    fun disableLogin_whenInvalidPassword() {
        val model = LoginModel(email = "test@gmail.com", loginEnabled = true)
        updateSpec
            .given(model)
            .whenEvent(PasswordChanged(password = "1234567"))
            .then(
                assertThatNext(
                    hasModel(model.copy(password = "1234567", loginEnabled = false))
                )
            )
    }

    @Test
    fun login_whenLoginRequested() {
        val model = LoginModel(
            email = "test@gmail.com",
            password = "1234",
            loginEnabled = true,
            errorMessage = "error"
        )
        updateSpec
            .given(model)
            .whenEvent(LoginRequested(model.email, model.password))
            .then(
                assertThatNext<LoginModel, LoginEffect>(
                    hasModel(model.copy(loggingIn = true, errorMessage = "")),
                    hasEffects(Login(model.email, model.password))
                )
            )
    }

    @Test
    fun saveCredentials_whenLoginSucceeded() {
        updateSpec
            .given(LoginModel())
            .whenEvent(LoginSucceeded(credentials = "access-token"))
            .then(
                assertThatNext<LoginModel, LoginEffect>(
                    hasEffects(SaveCredentials("access-token"))
                )
            )
    }

    @Test
    fun updateErrorMessage_whenLoginFailed() {
        val model = LoginModel()
        updateSpec
            .given(model)
            .whenEvent(LoginFailed(error = "error"))
            .then(assertThatNext(hasModel(model.copy(loggingIn = false, errorMessage = "error"))))
    }

    @Test
    fun navigateToSignUp_whenSignUpPressed() {
        updateSpec
            .given(LoginModel())
            .whenEvent(SignUpPressed)
            .then(assertThatNext<LoginModel, LoginEffect>(hasEffects(NavigateToSignUp)))
    }

    @Test
    fun resetPassword_whenResetPasswordRequested() {
        updateSpec
            .given(LoginModel())
            .whenEvent(ResetPasswordRequested(email = "test@gmail.com"))
            .then(
                assertThatNext<LoginModel, LoginEffect>(
                    hasEffects(ResetPassword(email = "test@gmail.com"))
                )
            )
    }

    @Test
    fun navigateToHome_whenSaveCredentialsCompleted() {
        updateSpec
            .given(LoginModel())
            .whenEvent(SaveCredentialsCompleted)
            .then(
                assertThatNext<LoginModel, LoginEffect>(hasEffects(NavigateToHome))
            )
    }

}