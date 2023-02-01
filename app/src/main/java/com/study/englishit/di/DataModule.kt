package com.study.englishit.di

import com.study.englishit.R
import com.study.englishit.domain.model.CardItemModel
import com.study.englishit.domain.model.PhrasesModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideTitlesToItems(): MutableList<CardItemModel> {
        return mutableListOf(
            CardItemModel(id = 0,  R.string.computer_terms_title, img = R.drawable.image1),
            CardItemModel(id = 1, R.string.useful_verbs, img = R.drawable.image2),
            CardItemModel(id = 2, R.string.greetings, img = R.drawable.image3),
            CardItemModel(id = 3, R.string.daily_routine, img = R.drawable.image4),
            CardItemModel(id = 4, R.string.pg_terms, img = R.drawable.image5),
            CardItemModel(id = 5, R.string.social_tech, img = R.drawable.image6),
            CardItemModel(id = 6, R.string.hobbies, img = R.drawable.image7),
            CardItemModel(id = 7, R.string.interviews_beginner, img = R.drawable.image8),
            CardItemModel(id = 8, R.string.code_terms, img = R.drawable.image9),
            CardItemModel(id = 9, R.string.useful_verbs2, img = R.drawable.image10),
            CardItemModel(id = 10, R.string.meetings, img = R.drawable.image11),
            CardItemModel(id = 11, R.string.job_terms, img = R.drawable.image12),


            )
    }

    @List1
    @Singleton
    @Provides
    fun providesPhrases(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(0, "I'm very well thank you! h'are u?", "Estoy muy bien , gracias. ¿Y vos como estas?", R.raw.howareyou),
            PhrasesModel(1, "how are you?", "como estas?",1),
            PhrasesModel(2, "fine and u?", "bien y vos?",1),
            PhrasesModel(3, "down", "abajo",1),
            PhrasesModel(4, "up", "arriba",1),
            PhrasesModel(5, "compute", "computadora",1),
            PhrasesModel(6, "glasses", "lentes",1),
            PhrasesModel(6, "glasses", "lentes",1),
            PhrasesModel(6, "glasses", "lentes",1),
            PhrasesModel(6, "glasses", "lentes",1),
            PhrasesModel(6, "glasses", "lentes",1),
        )
    }

    @List2
    @Singleton
    @Provides
    fun providesPhrases2(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(0, "NICE", "hola",R.raw.howareyou),
            PhrasesModel(1, "WOW", "como estas?",1),
            PhrasesModel(2, "IT WORKSS", "bien y vos?",1),
            PhrasesModel(3, "down", "abajo",1),
            PhrasesModel(4, "up", "arriba",1),
            PhrasesModel(5, "compute", "computadora",1),
            PhrasesModel(6, "glasses", "lentes",1),
            PhrasesModel(7, "glasses", "lentes",1),
            PhrasesModel(8, "glasses", "lentes",1),
            PhrasesModel(9, "glasses", "lentes",1),
            PhrasesModel(10, "glasses", "lentes",1),
            PhrasesModel(11, "glasses", "lentes",1),
        )
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class List1
    annotation class List2

}