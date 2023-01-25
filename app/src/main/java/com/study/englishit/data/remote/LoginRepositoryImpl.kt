package com.study.englishit.data.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.SetOptions
import com.study.englishit.di.FirebaseModule
import com.study.englishit.domain.model.User
import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.Constants.INFO_NOT_SET
import com.study.englishit.util.Constants.USER_LOGGED_IN_ID
import com.study.englishit.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    @FirebaseModule.UsersCollection private val usersCollection: CollectionReference,
) : LoginRepository {


    override suspend fun login(email: String, password: String): Flow<Result<Boolean>> = flow {
        emit(Result.Loading)
        try {
            var isSuccessful = false
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { isSuccessful = true }
                .addOnFailureListener { isSuccessful = false }
                .await()
            emit(Result.Success(isSuccessful))
            emit(Result.Finished)
        } catch (e: Exception) {
            emit(Result.Error(e))
            emit(Result.Finished)
        }
    }

    override suspend fun signUp(user: User, password: String): Flow<Result<User>> = flow {
        emit(Result.Loading)
        try {
            lateinit var exception: Exception
            var registeredUser = User()
            //register user when click on sign up btn
            auth.createUserWithEmailAndPassword(user.email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result.user!!
                        registeredUser = User(
                            email = user.email,
                            id = firebaseUser.uid
                        )
                    }
                    //with this else block exception we are gonna catch the error and pass it to the "lateinit var" that is up there
                    //and then in the last else branch we are gonna receive and emit a flow to say what exception was
                    else {
                        exception = task.exception!!
                    }
                }.await()
            //now if the user is register successfully we are gonna emit to the flow value (boolean)
            // that is true and we are gonna pass that user to the flow
            if (registeredUser.id != INFO_NOT_SET) {
                emit(Result.Success(registeredUser))
                emit(Result.Finished)
            }
            //this the the last else branch
            else {
                emit(Result.Error(exception))
                emit(Result.Finished)
            }

        } catch (e: Exception) {
            emit(Result.Error(e))
            emit(Result.Finished)
        }
    }

    override suspend fun logOut(): Flow<Result<Boolean>> = flow {
        emit(Result.Loading)
        try {
            auth.signOut()
            emit(Result.Success(true))
            emit(Result.Finished)
        } catch (e: Exception) {
            emit(Result.Error(e))
            emit(Result.Finished)
        }
    }

    override suspend fun getUserData(): Flow<Result<Boolean>> = flow {
        var requestStatus = false
        val currentUser = auth.currentUser
        emit(Result.Loading)
        try {
            currentUser?.uid?.let {
                usersCollection.document(it)
                    .get()
                    .addOnSuccessListener { document ->
                        val user = document.toObject(User::class.java)!!
                        requestStatus = true
                        USER_LOGGED_IN_ID = user.id
                    }
                    .addOnFailureListener {
                        requestStatus = false
                    }.await()
                emit(Result.Success(requestStatus))
                emit(Result.Finished)
            }
        } catch (e: Exception) {
            emit(Result.Error(e))
            emit(Result.Finished)
        }
    }

    override suspend fun saveUser(user: User): Flow<Result<Boolean>> = flow {
        emit(Result.Loading)
        try {
            var uploadStatus = false
            usersCollection.document(user.id).set(user, SetOptions.merge())
                .addOnSuccessListener { uploadStatus = true }
                .addOnFailureListener { uploadStatus = false }.await()
            emit(Result.Success(uploadStatus))
            emit(Result.Finished)
        } catch (e: Exception) {
            emit(Result.Error(e))
            emit(Result.Finished)
        }
    }
}