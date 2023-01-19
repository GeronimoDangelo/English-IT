package com.study.englishit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
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
        val btnSignUp = binding.btnSignUp
        val btnLogin = binding.btnLogin
        val etEmail = binding.etEmail.text.toString()
        val etPassword = binding.etPassword.text.toString()

        //Sign Up
        btnSignUp.setOnClickListener {
            if (etEmail.isNotEmpty() && etPassword.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(etEmail, etPassword)
                    .addOnCompleteListener {
                        val email = it.result.user?.email
                        if (it.isSuccessful && email != null) {
                            navigateToHome(
                                email = email,
                                provider = ProviderType.BASIC
                            )
                        } else {
                            showAlert()
                        }
                    }
            }
        }
        //Log In
        btnLogin.setOnClickListener {
            if (etEmail.isNotEmpty() && etPassword.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(etEmail, etPassword)
                    .addOnCompleteListener {
                        val email = it.result.user?.email
                        if (it.isSuccessful && email != null) {
                            navigateToHome(email = email, provider = ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }
        }
    }


    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Has been an error with user auth")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun navigateToHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra(USER_EMAIL_FB, email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}