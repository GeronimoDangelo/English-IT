package com.study.englishit.ui.presentation.navigation_screens

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.study.englishit.R
import com.study.englishit.databinding.FragmentItemsSavedBinding
import com.study.englishit.ui.presentation.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsSavedFragment : Fragment() {



    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private var _binding : FragmentItemsSavedBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentItemsSavedBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            activity?.finish()

        }
    }

}