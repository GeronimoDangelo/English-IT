package com.study.englishit.domain.model

import androidx.annotation.Keep
import com.study.englishit.util.Constants.INFO_NOT_SET
@Keep

data class User(
    val email: String = INFO_NOT_SET,
    val id: String = INFO_NOT_SET,
    var points: Long = 0,
)
