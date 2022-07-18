package com.abhi41.jetvalideform.domain.use_case.validationForm

//single source of truth principle
class ValidatePasswordUseCase {

    fun execute(password: String): ValidationResult {

        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "Password should contain atleast 8 characters"
            )
        }

        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }

        if (!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to contains at least one letter and digit"
            )
        }

        return ValidationResult(
            successful = true,
        )
    }

}