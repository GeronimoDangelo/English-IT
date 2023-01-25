package com.study.englishit.ui.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.englishit.R
import com.study.englishit.databinding.ActivityHomeBinding
import com.study.englishit.util.Constants.USER_LOGGED_IN_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private  var _binding : ActivityHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvID.text = "user id: $USER_LOGGED_IN_ID"
    }

}