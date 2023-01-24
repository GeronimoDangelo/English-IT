package com.study.englishit.domain.use_cases.signup

import com.study.englishit.domain.model.User
import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(user: User) : Flow<Result<Boolean>> =
        loginRepository.saveUser( user)

}