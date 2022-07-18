package com.abhi41.jetvalideform.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhi41.jetvalideform.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.annotation.meta.When
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val useCases: UseCases
) : ViewModel() {

    var state by mutableStateOf(RegistrationFormState())

    //purpose of this channel is sending events to this channel and ui will collect this changes by using flow etc.
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegistrationFormEvents) {
        when (event) {
            is RegistrationFormEvents.EmailChanged -> {
                //we use copy because we need to change the state object
                state = state.copy(email = event.email)
                //we can not do this
                //state.email = event.email
            }
            is RegistrationFormEvents.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegistrationFormEvents.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassowrd)
            }
            is RegistrationFormEvents.AcceptTerms -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }
            is RegistrationFormEvents.Sumbit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = useCases.validateEmailUseCase.execute(state.email)
        val passwordResult = useCases.validatePasswordUseCase.execute(state.password)
        val repeatedPasswordResult = useCases.validateRepeatedPasswordUseCase.execute(
            state.password, state.repeatedPassword
        )
        val termsResult = useCases.validateTermsUseCase.execute(state.acceptedTerms)
        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage
            )
            return
        }

        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}