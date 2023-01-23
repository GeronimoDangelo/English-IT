package com.study.englishit.ui.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.study.englishit.R
import com.study.englishit.databinding.FragmentLoginBinding
import com.study.englishit.ui.presentation.home.HomeActivity
import com.study.englishit.util.Constants.USER_NOT_EXIST
import com.study.englishit.util.Constants.WRONG_PASSWORD
import com.study.englishit.util.DataState
import com.study.englishit.util.isInputEmpty
import com.study.englishit.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() =_binding!!

    private val viewmodel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewmodel.loginState.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success<Boolean> -> {
                    viewmodel.getUserData()
                }
                is DataState.Error -> {
                    hideProgressDialog()
                    manageLoginErrorMessages(dataState.exception)
                }
                is DataState.Loading -> {
                    showProgressBar()
                }
                else -> Unit
            }
        }
        viewmodel.userDataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<Boolean> -> {
                    hideProgressDialog()
                    startActivity(Intent(requireContext(), HomeActivity::class.java))
                    activity?.finish()
                }
                is DataState.Error -> {
                    hideProgressDialog()
                    manageLoginErrorMessages(dataState.exception)
                }
                is DataState.Loading ->{
                    showProgressBar()
                }
                else -> Unit
            }
        })
    }

    private fun loginUser(){
        if (isUserDataOk()){
            showProgressBar()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            viewmodel.login(email, password)
        }
    }

    private fun isUserDataOk(): Boolean{
        return when{
            requireActivity().isInputEmpty(binding.etEmail  , true) -> {
                activity?.toast(getString(R.string.login__error_enter_email))
                false
            }

            requireActivity().isInputEmpty(binding.etPassword, true) -> {
                activity?.toast(getString(R.string.login__error_enter_password))
                false
            }

            else ->{
                true // the use enter all the data
            }
        }
    }


    private fun showProgressBar() {
        binding.btnLogin.text = "..."
        binding.btnLogin.isEnabled = false
        binding.pbLogin.visibility = View.VISIBLE
    }

    private fun manageLoginErrorMessages(exception: Exception) {
        when(exception.message){
            USER_NOT_EXIST -> { activity?.toast(getString(R.string.login__error_user_no_registered)) }
            WRONG_PASSWORD -> { activity?.toast(getString(R.string.login__error_wrong_password)) }
            else -> { activity?.toast(getString(R.string.login__error_unknown_error)) }
        }
    }

    private fun hideProgressDialog() {
        binding.pbLogin.visibility = View.GONE
        binding.btnLogin.text = getString(R.string.login__login_button)
        binding.btnLogin.isEnabled = true
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            loginUser()
        }
        binding.btnSingUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)

        }
    }
}