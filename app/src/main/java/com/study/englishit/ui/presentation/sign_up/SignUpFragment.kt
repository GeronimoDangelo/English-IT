package com.study.englishit.ui.presentation.sign_up

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.study.englishit.R
import com.study.englishit.databinding.FragmentLoginBinding
import com.study.englishit.databinding.FragmentSignUpBinding
import com.study.englishit.ui.presentation.login.LoginActivity
import com.study.englishit.ui.presentation.login.LoginFragment

class SignUpFragment : Fragment() {
    private var binding: FragmentSignUpBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

private fun initListeners(){
    binding?.btnBack?.setOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
    binding?.btnSignUp?.setOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}

}
