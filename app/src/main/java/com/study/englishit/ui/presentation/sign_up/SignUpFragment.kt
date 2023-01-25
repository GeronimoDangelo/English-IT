package com.study.englishit.ui.presentation.sign_up

import android.content.Context
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.study.englishit.R
import com.study.englishit.databinding.FragmentSignUpBinding
import com.study.englishit.domain.model.User
import com.study.englishit.util.Constants.EMAIL_ALREADY_EXISTS
import com.study.englishit.util.Result
import com.study.englishit.util.isInputEmpty
import com.study.englishit.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
        setupPolicyLink()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.signUpState.collectLatest { result ->
                when (result) {
                    is Result.Success<User> -> {
                        viewModel.saveUser(user = result.data)
                    }
                    is Result.Error -> {
                        hideProgressDialog()
                        manageRegisterErrorMessages(result.exception)
                    }
                    is Result.Loading -> {
                        showProgressBar()
                    }
                    else -> Unit
                }
            }
        }


        lifecycleScope.launchWhenStarted {

            viewModel.saveUserState.collectLatest { result ->
                when (result) {
                    is Result.Success<Boolean> -> {
                        activity?.toast(getString(R.string.signup__signup_successfully))
                        activity?.onBackPressedDispatcher?.onBackPressed()
                    }
                    is Result.Error -> {
                        hideProgressDialog()
                        manageRegisterErrorMessages(result.exception)
                    }
                    is Result.Loading -> {
                        showProgressBar()
                    }
                    else -> {}
                }

            }
        }

    }


    private fun createUser(): User {
        val email = binding.etEmail.text.toString()
        return User(
            email = email
        )
    }

    private fun isUserDataOk(): Boolean {
        return when {
            requireActivity().isInputEmpty(binding.etEmail, true) -> false
            isPasswordInsecure() -> {
                activity?.toast(getString(R.string.signup__error_passwords_match))
                false
            }
            else -> true
        }
    }

    private fun isPasswordInsecure(): Boolean {
        return if (binding.etPassword.text.toString().length <= 6) {
            activity?.toast(getString(R.string.signup__error_password_insecure))
            true
        } else {
            binding.etPassword.text.toString() != binding.etConfirmPassword.text.toString()
        }
    }

    private fun showProgressBar() {
        binding.btnSignUp.text = "..."
        binding.btnSignUp.isEnabled = false
        binding.pbSignUp.visibility = View.VISIBLE
    }

    private fun manageRegisterErrorMessages(exception: Exception) {
        if (exception.toString() == EMAIL_ALREADY_EXISTS) {
            activity?.toast(getString(R.string.signup__error_email_already_registered))
        } else {
            activity?.toast(getString(R.string.signup__error_unknown_error))
        }
    }

    private fun hideProgressDialog() {
        binding.pbSignUp.visibility = View.GONE
        binding.btnSignUp.text = getString(R.string.signup__signup_button)
        binding.btnSignUp.isEnabled = true

    }

    private fun closeKeyboard(view: View){
        val imn = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        binding.btnSignUp.setOnClickListener {
            if (isUserDataOk()) {
                viewModel.signUp(createUser(), binding.etPassword.text.toString())
                closeKeyboard(binding.btnSignUp)
            }
        }
    }

    private fun setupPolicyLink() {
        val tvLinkPolicy = binding.tvLinkPolicy
        tvLinkPolicy.movementMethod = LinkMovementMethod.getInstance()
    }


}
