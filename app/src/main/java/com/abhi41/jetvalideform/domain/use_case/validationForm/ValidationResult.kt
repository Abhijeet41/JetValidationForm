package com.abhi41.jetvalideform.domain.use_case.validationForm

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
