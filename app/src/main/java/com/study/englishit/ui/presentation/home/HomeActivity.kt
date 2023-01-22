package com.study.englishit.ui.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.englishit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_EnglishIT)
        setContentView(R.layout.activity_home)
    }
}