package com.study.englishit.di

import androidx.annotation.Keep
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.study.englishit.util.Constants.USER_COLLECTIONS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Keep
@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireStore(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @UsersCollection
    @Provides
    @Singleton
    fun provideUsersCollection(
        firestore: FirebaseFirestore
    ): CollectionReference {
        return firestore.collection(USER_COLLECTIONS)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UsersCollection

}