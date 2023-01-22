package com.study.englishit.data.remote

import android.provider.ContactsContract.Data
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.toObject
import com.study.englishit.di.FirebaseModule
import com.study.englishit.domain.model.User
import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.util.Constants.INFO_NOT_SET
import com.study.englishit.util.Constants.USER_LOGGED_IN_ID
import com.study.englishit.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    @FirebaseModule.UsersCollection private val usersCollection: CollectionReference,
) : LoginRepository {


    override suspend fun login(email: String, password: String): Flow<DataState<Boolean>> = flow {
        emit(DataState.Loading)
        try {
            var isSuccessful: Boolean = false
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { isSuccessful = true }
                .addOnFailureListener { isSuccessful = false }
                .await()
            emit(DataState.Success(isSuccessful))
            emit(DataState.Finished)
        } catch (e: Exception) {
            emit(DataState.Error(e))
            emit(DataState.Finished)
        }
    }

    override suspend fun signUp(user: User, password: String): Flow<DataState<User>> = flow {
        emit(DataState.Loading)
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
                emit(DataState.Success(registeredUser))
                emit(DataState.Finished)
            }
            //this the the last else branch
            else {
                emit(DataState.Error(exception))
                emit(DataState.Finished)
            }

        } catch (e: Exception) {
            emit(DataState.Error(e))
            emit(DataState.Finished)
        }
    }

    override suspend fun logOut(): Flow<DataState<Boolean>> = flow {
        emit(DataState.Loading)
        try {
            auth.signOut()
            emit(DataState.Success(true))
            emit(DataState.Finished)
        } catch (e: Exception) {
            emit(DataState.Error(e))
            emit(DataState.Finished)
        }
    }

    override suspend fun getUserData(): Flow<DataState<Boolean>> = flow {
        var requestStatus = false
        val currentUser = auth.currentUser
        emit(DataState.Loading)
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
                emit(DataState.Success(requestStatus))
                emit(DataState.Finished)
            }
        } catch (e: Exception) {
            emit(DataState.Error(e))
            emit(DataState.Finished)
        }
    }

    override suspend fun saveUser(user: User): Flow<DataState<Boolean>> = flow {
        emit(DataState.Loading)
        try {
            var uploadStatus: Boolean = false
            usersCollection.document(user.id).set(user, SetOptions.merge())
                .addOnSuccessListener { uploadStatus = true }
                .addOnFailureListener { uploadStatus = false }.await()
            emit(DataState.Success(uploadStatus))
            emit(DataState.Finished)
        } catch (e: Exception) {
            emit(DataState.Error(e))
            emit(DataState.Finished)
        }
    }
}