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
            CardItemModel(id = 0, "Level 1", img = R.drawable.image1),
            CardItemModel(id = 1, "Intermediate 2", img = R.drawable.image2),
            CardItemModel(id = 2, "Advanced 3", img = R.drawable.image3),
            CardItemModel(id = 3, "Full Native 4", img = R.drawable.image4),
            CardItemModel(id = 4, "Alien 5", img = R.drawable.image5),
            CardItemModel(id = 5, "Interviews", img = R.drawable.image6),
            CardItemModel(id = 6, "Hobbies", img = R.drawable.image7),
            CardItemModel(id = 7, "Interviews \n Advanced", img = R.drawable.image8),
            CardItemModel(id = 8, "Interviews\n Advanced", img = R.drawable.image9),
            CardItemModel(id = 9, "Interviews \n Advanced", img = R.drawable.image10),
            CardItemModel(id = 10, "Interviews\n Advanced", img = R.drawable.image11),
            CardItemModel(id = 11, "Interviews \nAdvanced", img = R.drawable.image12),

            )
    }

    @List1
    @Singleton
    @Provides
    fun providesPhrases(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(0, "hello", "hola"),
            PhrasesModel(1, "how are you?", "como estas?"),
            PhrasesModel(2, "fine and u?", "bien y vos?"),
            PhrasesModel(3, "down", "abajo"),
            PhrasesModel(4, "up", "arriba"),
            PhrasesModel(5, "compute", "computadora"),
            PhrasesModel(6, "glasses", "lentes"),
            PhrasesModel(6, "glasses", "lentes"),
            PhrasesModel(6, "glasses", "lentes"),
            PhrasesModel(6, "glasses", "lentes"),
            PhrasesModel(6, "glasses", "lentes"),
        )
    }

    @List2
    @Singleton
    @Provides
    fun providesPhrases2(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(0, "NICE", "hola"),
            PhrasesModel(1, "WOW", "como estas?"),
            PhrasesModel(2, "IT WORKSS", "bien y vos?"),
            PhrasesModel(3, "down", "abajo"),
            PhrasesModel(4, "up", "arriba"),
            PhrasesModel(5, "compute", "computadora"),
            PhrasesModel(6, "glasses", "lentes"),
            PhrasesModel(7, "glasses", "lentes"),
            PhrasesModel(8, "glasses", "lentes"),
            PhrasesModel(9, "glasses", "lentes"),
            PhrasesModel(10, "glasses", "lentes"),
            PhrasesModel(11, "glasses", "lentes"),
        )
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class List1
    annotation class List2

}