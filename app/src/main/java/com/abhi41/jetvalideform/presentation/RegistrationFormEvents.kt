package com.abhi41.jetvalideform.presentation

sealed class RegistrationFormEvents {
    data class EmailChanged(val email: String) : RegistrationFormEvents()
    data class PasswordChanged(val password: String) : RegistrationFormEvents()
    data class RepeatedPasswordChanged(val repeatedPassowrd: String) : RegistrationFormEvents()
    data class AcceptTerms(val isAccepted: Boolean) : RegistrationFormEvents()

    object Sumbit : RegistrationFormEvents()
}
