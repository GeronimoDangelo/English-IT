package com.study.englishit.domain.use_cases.logout

import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
   private val loginRepository: LoginRepository
) {
    suspend operator fun invoke () : Flow<Result<Boolean>> =
        loginRepository.logOut()

}