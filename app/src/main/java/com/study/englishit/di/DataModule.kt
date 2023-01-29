package com.study.englishit.di

import com.study.englishit.R
import com.study.englishit.domain.model.CardItemModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideTitlesToItems() : List<CardItemModel>{
        return listOf(
            CardItemModel(id= 1 ,  "Level 1", img = R.drawable.image1),
            CardItemModel(id= 2 ,  "Intermediate 2",img = R.drawable.image2),
            CardItemModel(id= 3 ,  "Advanced 3",img = R.drawable.image3),
            CardItemModel(id= 4 ,  "Full Native 4",img = R.drawable.image4),
            CardItemModel(id= 5 ,  "Alien 5",img = R.drawable.image5),
            CardItemModel(id= 5 ,  "Interviews",img = R.drawable.image6),
            CardItemModel(id= 5 ,  "Hobbies", img = R.drawable.image7),
            CardItemModel(id= 5 ,  "Interviews \n Advanced", img = R.drawable.image8),
            CardItemModel(id= 5 ,  "Interviews\n Advanced",img = R.drawable.image9),
            CardItemModel(id= 5 ,  "Interviews \n Advanced",img = R.drawable.image10),
            CardItemModel(id= 5 ,  "Interviews\n Advanced",img = R.drawable.image11),
            CardItemModel(id= 5 ,  "Interviews \nAdvanced",img = R.drawable.image12),

        )
    }


}