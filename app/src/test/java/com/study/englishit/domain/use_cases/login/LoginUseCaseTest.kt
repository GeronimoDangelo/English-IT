package com.study.englishit.domain.use_cases.login

import androidx.work.ListenableWorker.Result.Success
import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.DataState
import io.mockk.MockKAnnotations
import io.mockk.MockKStubScope
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


 internal class LoginUseCaseTest {

    @RelaxedMockK
    private lateinit var loginRepository: LoginRepository


    lateinit var loginUseCase: LoginUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        loginUseCase = LoginUseCase(loginRepository)
    }

    @Test
    fun `when the login repo has empty forms , returns empty `() = runBlocking{
        //given
        coEvery { loginRepository.login(email = "", password = "") } returns emptyFlow()
        //when
        loginUseCase("","")
        //then
        coVerify (exactly = 1) { loginRepository.login("","") }
    }





 }

