package com.abhi41.jetvalideform.di

import com.abhi41.jetvalideform.domain.use_case.UseCases
import com.abhi41.jetvalideform.domain.use_case.validationForm.ValidateEmailUseCase
import com.abhi41.jetvalideform.domain.use_case.validationForm.ValidatePasswordUseCase
import com.abhi41.jetvalideform.domain.use_case.validationForm.ValidateRepeatedPasswordUseCase
import com.abhi41.jetvalideform.domain.use_case.validationForm.ValidateTermsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(): UseCases {
        return UseCases(
            validateEmailUseCase = ValidateEmailUseCase(),
            validatePasswordUseCase = ValidatePasswordUseCase(),
            validateRepeatedPasswordUseCase = ValidateRepeatedPasswordUseCase(),
            validateTermsUseCase = ValidateTermsUseCase()
        )
    }

}