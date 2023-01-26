package com.study.englishit.ui.presentation.recovery_password

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.study.englishit.R
import com.study.englishit.databinding.FragmentRecoveryPasswordBinding
import com.study.englishit.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecoveryPasswordFragment : Fragment() {

    private var _binding: FragmentRecoveryPasswordBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RecoveryPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecoveryPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.recoveryPassword.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success<Boolean> -> {
                    hideProgressDialog()
                    activity?.onBackPressedDispatcher?.onBackPressed()
                    Toast.makeText(requireContext(),"hemos enviado un link para reestablecer tu contraseña", Toast.LENGTH_LONG).show()
                }
                is DataState.Error -> {
                    hideProgressDialog()
                    Toast.makeText(requireContext(),dataState.exception.toString(), Toast.LENGTH_LONG).show()

                }
                is DataState.Loading -> {
                    showProgressBar()
                }
                else -> Unit
            }
        }
    }


    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        binding.btnRecovery.setOnClickListener {
            handleRecoveryPassword()
        }

    }


    private fun handleRecoveryPassword() {
        val email = binding.etEmail.text.toString().trim()
        viewModel.sendRecoveryPassword(email)
    }

    private fun showProgressBar() {
        binding.btnRecovery.text = "..."
        binding.btnRecovery.isEnabled = false
        binding.pbRecovery.visibility = View.VISIBLE
    }

    private fun hideProgressDialog() {
        binding.pbRecovery.visibility = View.GONE
        binding.btnRecovery.text = getString(R.string.send_recovery_password)
        binding.btnRecovery.isEnabled = true
    }

}