package com.abhi41.jetvalideform.domain.use_case.validationForm

//single source of truth principle
class ValidateTermsUseCase {

    fun execute(acceptedTerms: Boolean): ValidationResult {

        if (!acceptedTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "Please accept the terms"
            )
        }

        return ValidationResult(
            successful = true,
        )
    }

}