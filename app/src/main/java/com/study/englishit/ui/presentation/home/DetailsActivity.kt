package com.study.englishit.ui.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.englishit.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getStringExtra("details")
        val intentInt = getIntent().getIntExtra("detailsInt",0)

        binding.ivHeadImg.setImageResource(intentInt)
        binding.tvIterator.text = intent


    }
}