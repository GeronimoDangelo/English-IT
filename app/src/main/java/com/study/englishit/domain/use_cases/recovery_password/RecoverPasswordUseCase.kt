package com.study.englishit.domain.use_cases.recovery_password

import com.google.firebase.auth.FirebaseAuth
import com.study.englishit.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RecoverPasswordUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    suspend operator fun invoke(email: String): Flow<DataState<Boolean>> = flow {
        try {
            emit(DataState.Loading)
            var isSuccessful = false
            firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { isSuccessful = it.isSuccessful }
                .await()
            emit(DataState.Success(isSuccessful))
            emit(DataState.Finished)
        } catch (e: Exception) {
            emit(DataState.Error(e))
            emit(DataState.Finished)
        }

    }

}