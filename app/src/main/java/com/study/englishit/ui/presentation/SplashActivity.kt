package com.study.englishit.ui.presentation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.study.englishit.ui.presentation.home.HomeActivity
import com.study.englishit.ui.presentation.login.LoginActivity
import com.study.englishit.ui.presentation.login.LoginViewModel
import com.study.englishit.util.Constants.SHARED_EMAIL
import com.study.englishit.util.Constants.SHARED_PASSWORD
import com.study.englishit.util.DataState
import com.study.englishit.util.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val viewmodel: LoginViewModel by viewModels()

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
        if (userIsLogged()) {
            viewmodel.login(getSavedEmail()!!, getSavedPassword()!!)
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun initObservers() {
        viewmodel.loginState.observe(this) { result ->
            when (result) {
                is DataState.Success<Boolean> -> {
                    viewmodel.getUserData()
                }
                is DataState.Error -> {
                    toast("las contraseñas no son validas")
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                else -> Unit
            }
        }

        viewmodel.userDataState.observe(this) { result ->
            when (result) {
                is DataState.Success<Boolean> -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
                is DataState.Error -> {
                    toast("las contraseñas no son validas")
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                else -> Unit
            }
        }


    }

    private fun userIsLogged(): Boolean {
        return getSavedEmail()?.isNotEmpty() == true && getSavedPassword()?.isNotEmpty() == true
    }


    private fun getSavedEmail() = sharedPreferences.getString(SHARED_EMAIL, "")
    private fun getSavedPassword() = sharedPreferences.getString(SHARED_PASSWORD, "")

}