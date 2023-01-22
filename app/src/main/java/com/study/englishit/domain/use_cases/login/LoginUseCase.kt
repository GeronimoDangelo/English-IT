package com.study.englishit.domain.use_cases.login

import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){
    suspend operator fun invoke(email:String, password: String) : Flow<DataState<Boolean>> =
         loginRepository.login( email,  password)

}