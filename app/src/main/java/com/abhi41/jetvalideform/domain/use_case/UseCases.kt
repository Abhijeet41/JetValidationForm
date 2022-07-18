package com.abhi41.jetvalideform.domain.use_case

import com.abhi41.jetvalideform.domain.use_case.validationForm.ValidateEmailUseCase
import com.abhi41.jetvalideform.domain.use_case.validationForm.ValidatePasswordUseCase
import com.abhi41.jetvalideform.domain.use_case.validationForm.ValidateRepeatedPasswordUseCase
import com.abhi41.jetvalideform.domain.use_case.validationForm.ValidateTermsUseCase

data class UseCases(
    val validateEmailUseCase: ValidateEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateRepeatedPasswordUseCase: ValidateRepeatedPasswordUseCase,
    val validateTermsUseCase: ValidateTermsUseCase
)
