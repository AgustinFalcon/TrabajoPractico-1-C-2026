package com.agusstkd.fasekotlin.fragments

import androidx.core.util.PatternsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    //var viewState = MutableLiveData<SecondStateEnum>()
    var viewState = MutableLiveData<SecondStatesSealed>()

    private var email: String = ""
    private var password: String = ""


    fun validateEmail(email: String) {
        this.email = email
        if (email.isNotBlank() && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
             //viewState.value = SecondStateEnum.SUCCESS_EMAIL
            viewState.value = SecondStatesSealed.SuccessEmail

        } else {
            //viewState.value = SecondStateEnum.ERROR_EMAIL
            viewState.value = SecondStatesSealed.ErrorEmail
        }

        validateButtons()
    }

    fun validatePassword(password: String) {
        this.password = password
        if (password.isNotBlank() && password.length > 3) {
            //viewState.value = SecondStateEnum.SUCCESS_PASSWORD
            viewState.value = SecondStatesSealed.SuccessPassword

        } else {
            //viewState.value = SecondStateEnum.ERROR_PASSWORD
            viewState.value = SecondStatesSealed.ErrorPassword(password = password)
        }

        validateButtons()
    }

    fun validateButtons() {
        if ((email.isNotBlank() && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches())
            && (password.isNotBlank() && password.length > 3)) {

            viewState.value = SecondStatesSealed.SuccessButton
        } else {
            viewState.value = SecondStatesSealed.ErrorButton
        }
    }
}

enum class SecondStateEnum {
    SUCCESS_EMAIL,
    ERROR_EMAIL,
    SUCCESS_PASSWORD,
    ERROR_PASSWORD,
    ERROR_BUTTON,
    SUCCESS_BUTTON
}

sealed class SecondStatesSealed() {
    object SuccessEmail: SecondStatesSealed()
    object ErrorEmail: SecondStatesSealed()
    object SuccessPassword: SecondStatesSealed()
    data class ErrorPassword(val password: String): SecondStatesSealed()
    object ErrorButton: SecondStatesSealed()
    object SuccessButton: SecondStatesSealed()
}
