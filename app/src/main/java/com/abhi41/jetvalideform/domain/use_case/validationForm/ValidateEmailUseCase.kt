package com.abhi41.jetvalideform.domain.use_case.validationForm

import android.util.Patterns

//single source of truth principle
class ValidateEmailUseCase {

    fun execute(email: String): ValidationResult {

        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "This email can't be blank"
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                successful = false,
                errorMessage = "That's not a valid email address"
            )
        }

        return ValidationResult(
            successful = true,
        )
    }

}