package com.study.englishit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.study.englishit.databinding.AuthActivityBinding
import com.study.englishit.util.Constants.USER_EMAIL_FB

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: AuthActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_EnglishIT)
        binding = AuthActivityBinding.inflate(layoutInflater)
        val authScreen = binding.root
        setContentView(authScreen)
        //variables



        //Sign Up
        binding.btnSignUp.setOnClickListener {
            val etEmail = binding.etEmail.text.toString()
            val etPassword = binding.etPassword.text.toString()
            if (etEmail.isNotEmpty() && etPassword.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(etEmail, etPassword)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            navigateToHome(
                                email = it.result.user?.email ?: ""
                            )
                        } else {
                            showFailedRegister()
                        }
                    }
            }
        }
        //Log In
        binding.btnLogin.setOnClickListener {
            val etEmail = binding.etEmail.text.toString()
            val etPassword = binding.etPassword.text.toString()
            if (etEmail.isNotEmpty() && etPassword.isNotEmpty()) {

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(etEmail, etPassword)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            navigateToHome(email = it.result.user?.email ?: "")
                        } else {
                            showNoUserRegister()
                        }
                    }
            }
        }
    }


    private fun showNoUserRegister() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sorry but..")
        builder.setMessage("You have to register first.")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showFailedRegister() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Check your forms")
        builder.setMessage("The password has to be 6 character minimum, and check that the email was correctly written")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }



    private fun navigateToHome(email: String) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra(USER_EMAIL_FB, email)
        }
        startActivity(homeIntent)
    }
}