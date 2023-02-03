package com.study.englishit.ui.presentation.navigation_screens

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.study.englishit.databinding.FragmentSettingsBinding
import com.study.englishit.ui.presentation.home.HomeViewModel
import com.study.englishit.util.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {


    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initListeners()
    }

    private fun initObserver() {
        homeViewModel.getPoints()
        homeViewModel.totalPoints.observe(viewLifecycleOwner){
            binding.points.text = it.toString()
        }

    }

    private fun initListeners() {
        binding.button.setOnClickListener {
           saveData()
        }
    }

    private fun saveData() {
        homeViewModel.lessonCompleted()
        val total = homeViewModel.totalPoints.value!!
        sharedPreferences.edit().putInt("count",total).apply()
        activity?.toast("data saved")

    }


}

