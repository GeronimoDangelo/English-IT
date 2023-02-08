package com.study.englishit.ui.presentation.home

import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
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
        MobileAds.initialize(this)
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


    private fun initObservers() {
        homeViewModel.getPoints()
        //for pas the number into text and into top bar
        val total = sharedPreferences.getInt(DATA_POINTS_KEY, 0).toString()
        binding.points.text = total
        //

        //for pas the points to viewmodel as int
        val totalPoints = sharedPreferences.getInt(DATA_POINTS_KEY, 0)
        fun providePoints(points: Int = 1) {
            homeViewModel.lessonCompleted(points)
            homeViewModel.saveData()
        }

        if (totalPoints == 45) {
            providePoints()
            dialog()
        }
        if (totalPoints == 106) {
            providePoints()
            dialog()
        }
        if (totalPoints == 152) {
            providePoints()
            dialog()
        }
        if (totalPoints == 308) {
            providePoints()
            dialog()
        }

        if (totalPoints == 2022) {
            providePoints()
            dialog()
        }


    }


    private fun dialog() {
        AlertDialog.Builder(this)
            .setTitle("¡Felicidades! \uD83E\uDD8A")
            .setMessage("Has desbloqueado un nuevo logro! Ve a logros y descubre tu recompensa!")
            .setPositiveButton("Ok") { _, _ ->
            }.create()
            .show()
    }


}