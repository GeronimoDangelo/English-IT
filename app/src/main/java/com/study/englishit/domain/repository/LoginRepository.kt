package com.study.englishit.domain.repository

import com.study.englishit.domain.model.User
import com.study.englishit.util.Result
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(email:String,password: String): Flow<Result<Boolean>>

    suspend fun signUp(user: User,password: String): Flow<Result<User>>

    suspend fun logOut(): Flow<Result<Boolean>>

    suspend fun getUserData(): Flow<Result<Boolean>>

    suspend fun saveUser(user: User): Flow<Result<Boolean>>

}