package com.study.englishit.ui.presentation.navigation_screens

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.study.englishit.R
import com.study.englishit.databinding.FragmentItemsSavedBinding
import com.study.englishit.domain.repository.LoginRepository
import com.study.englishit.ui.presentation.login.LoginActivity
import com.study.englishit.ui.presentation.login.LoginViewModel
import com.study.englishit.util.Constants
import com.study.englishit.util.Constants.DATA_POINTS_KEY
import com.study.englishit.util.Constants.SHARED_EMAIL
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@AndroidEntryPoint
class ItemsSavedFragment : Fragment() {

    private val loginViewModel : LoginViewModel by viewModels()

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
        initObservers()
        initListeners()

    }

    private fun initObservers() {
        val email = sharedPreferences.getString(SHARED_EMAIL,"email not recovered")
        val totalPoints = sharedPreferences.getInt(DATA_POINTS_KEY,0)
        binding.tvEmail.text = email
        binding.tvPoints.text = "Puntos: $totalPoints"
    }

    private fun initListeners() = with(binding) {
        btnLogout.setOnClickListener {
            loginViewModel.logOut()
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            activity?.finish()

        }
        btnMasinfo.setOnClickListener {
            findNavController().navigate(R.id.action_itemsSavedFragment_to_moreAppInfoFragment)
        }
        compartir.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "✨ Aprende ingles con frases reales! \uD83E\uDD8A \n Englisht IT \uD83E\uDD8A \n https://play.google.com/store/apps/details?id=com.coffee.bookapp")
            startActivity(Intent.createChooser(shareIntent,"Share app via"))
        }
    }

}