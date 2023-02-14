package com.study.englishit.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Keep

@Parcelize
data class CardItemModel(
    val id : Int,
    @StringRes val title: Int,
    @DrawableRes val img: Int,
) : Parcelable
