package com.abhi41.jetvalideform.domain.use_case.validationForm

//single source of truth principle
class ValidateRepeatedPasswordUseCase {

    fun execute(password: String, repeatedPassword: String): ValidationResult {

        if (password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "The passwords don;t match"
            )
        }

        return ValidationResult(
            successful = true,
        )
    }

}