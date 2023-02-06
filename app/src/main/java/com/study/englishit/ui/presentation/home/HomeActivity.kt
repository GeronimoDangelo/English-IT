package com.study.englishit.ui.presentation.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.firebase.auth.FirebaseAuth
import com.study.englishit.R
import com.study.englishit.databinding.ActivityHomeBinding
import com.study.englishit.util.Constants.DATA_POINTS_KEY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val screen = binding.root
        setContentView(screen)
        homeViewModel.getPoints()
        NavigationUI.setupWithNavController(
            binding.bottomNavMenu,
            findNavController(R.id.fragmentActivityHome),
        )
        initObservers()
    }

    override fun onResume() {
        super.onResume()
        initObservers()
    }

    fun initObservers() {
        homeViewModel.getPoints()
        val total = sharedPreferences.getInt(DATA_POINTS_KEY, 0).toString()
        binding.points.text = total
    }
}