package com.study.englishit.di

import android.content.SharedPreferences
import androidx.annotation.Keep
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.study.englishit.data.remote.LoginRepositoryImpl
import com.study.englishit.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Keep
@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        auth: FirebaseAuth,
        @FirebaseModule.UsersCollection usersCollection: CollectionReference,
        sharedPreferences: SharedPreferences
    ): LoginRepository {
        return LoginRepositoryImpl(auth = auth, usersCollection = usersCollection, sharedPreferences =  sharedPreferences)
    }

}