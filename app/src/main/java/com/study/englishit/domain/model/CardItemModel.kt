package com.study.englishit.domain.model

import androidx.annotation.DrawableRes

data class CardItemModel(
    val id : Int,
    val title: String,
    @DrawableRes val img: Int
)
