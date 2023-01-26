package com.study.englishit.ui.presentation.home

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.study.englishit.databinding.ActivityHomeBinding
import com.study.englishit.ui.presentation.login.LoginActivity
import com.study.englishit.ui.presentation.login.LoginViewModel
import com.study.englishit.util.Constants.SHARED_EMAIL
import com.study.englishit.util.Constants.SHARED_PASSWORD
import com.study.englishit.util.Constants.USER_EMAIL_GET
import com.study.englishit.util.Constants.USER_LOGGED_IN_ID
import com.study.englishit.util.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences
    private val viewmodel: LoginViewModel by viewModels()


    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvID.text = "user id: $USER_LOGGED_IN_ID"
        binding.tvEmail.text = USER_EMAIL_GET
        initListeners()
    }

    private fun initListeners() {
        binding.log.setOnClickListener {
            viewmodel.logOut()
            manageUserLogOut()
        }
    }

    private fun manageUserLogOut() {
        sharedPreferences.edit().remove(SHARED_EMAIL).apply()
        sharedPreferences.edit().remove(SHARED_PASSWORD).apply()
        toast("log out succesfully")
        startActivity(Intent(this, LoginActivity::class.java))
    }


}