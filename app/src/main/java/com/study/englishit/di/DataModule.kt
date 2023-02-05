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
    fun provideTitlesToItems(): MutableList<CardItemModel> {
        return mutableListOf(
            CardItemModel(id = 0, R.string.computer_terms_title, img = R.drawable.image1),
            CardItemModel(id = 1, R.string.useful_verbs, img = R.drawable.image2),
            CardItemModel(id = 2, R.string.greetings, img = R.drawable.zoom1),
            CardItemModel(id = 3, R.string.daily_routine, img = R.drawable.zoom11),
            CardItemModel(id = 4, R.string.pg_terms, img = R.drawable.cozy),
            CardItemModel(id = 5, R.string.social_tech, img = R.drawable.zoom3),
            CardItemModel(id = 6, R.string.hobbies, img = R.drawable.image7),
            CardItemModel(id = 7, R.string.interviews_beginner, img = R.drawable.zoom2),
            CardItemModel(id = 8, R.string.code_terms, img = R.drawable.zoom12),
            CardItemModel(id = 9, R.string.useful_verbs2, img = R.drawable.image10),
            CardItemModel(id = 10, R.string.meetings, img = R.drawable.image11),
            CardItemModel(id = 11, R.string.travel, img = R.drawable.zoom5),
            CardItemModel(id = 12, R.string.vacations, img = R.drawable.image5),
            CardItemModel(id = 13, R.string.recruiter, img = R.drawable.image3),
            CardItemModel(id = 14, R.string.software, img = R.drawable.zoom10),
            CardItemModel(id = 15, R.string.algorithms, img = R.drawable.image4),
            CardItemModel(id = 16, R.string.interviewsfinal, img = R.drawable.image8),
            CardItemModel(id = 17, R.string.job_meeting, img = R.drawable.zoom4),
        )
    }

}