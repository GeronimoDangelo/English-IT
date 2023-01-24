package com.study.englishit.domain.use_cases.login

import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){
    suspend operator fun invoke(email:String, password: String) : Flow<Result<Boolean>> =

         loginRepository.login( email,  password)


}