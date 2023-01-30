package com.study.englishit.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardItemModel(
    val id : Int,
    val title: String,
    @DrawableRes val img: Int
) : Parcelable
