package com.study.englishit.domain.use_cases.signup

import com.study.englishit.domain.model.User
import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(user: User) : Flow<DataState<Boolean>> =
        loginRepository.saveUser( user)

}