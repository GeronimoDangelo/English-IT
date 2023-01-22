package com.study.englishit.domain.use_cases.signup

import com.study.englishit.domain.model.User
import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(user: User,  password :String) : Flow<DataState<User>> =
        loginRepository.signUp( user,  password)

}