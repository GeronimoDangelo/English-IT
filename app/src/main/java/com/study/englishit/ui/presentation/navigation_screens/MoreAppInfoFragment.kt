package com.study.englishit.ui.presentation.navigation_screens

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.study.englishit.R
import com.study.englishit.databinding.FragmentMoreAppInfoBinding
import com.study.englishit.databinding.FragmentSignUpBinding


class MoreAppInfoFragment : Fragment() {

    private var _binding: FragmentMoreAppInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMoreAppInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPolicyLink()
        binding.btnBackToProfile.setOnClickListener{
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }



    private fun setupPolicyLink() {
        val tvLinkPolicy = binding.tvLucy
        tvLinkPolicy.movementMethod = LinkMovementMethod.getInstance()
        val tvLinkPolicy2 = binding.tvEnglisSucces
        tvLinkPolicy2.movementMethod = LinkMovementMethod.getInstance()
    }

}