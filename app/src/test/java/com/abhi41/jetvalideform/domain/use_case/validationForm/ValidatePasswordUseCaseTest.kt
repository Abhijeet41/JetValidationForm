package com.abhi41.jetvalideform.domain.use_case.validationForm

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ValidatePasswordUseCaseTest {

    private lateinit var validatePassoword: ValidatePasswordUseCase

    @Before
    fun setUp() {
        validatePassoword = ValidatePasswordUseCase()
    }

    @Test
    fun `Password is letter-only, returns error`(){
        val result = validatePassoword.execute("abcdefgh")
        val result2 = validatePassoword.execute("")
        assertEquals(result.successful,false)
        assertEquals(result2.successful,false)
    }


}