package com.study.englishit.domain.model

data class PhrasesModel(
    val id: Int,
    val title: String,
    val desc: String,
    val audio: Int,
    var isExpandable: Boolean = false,
)