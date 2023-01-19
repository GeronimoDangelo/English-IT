package com.study.englishit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
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
                        try {
                            val msjError =
                                "com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account"
                            //
                            if (it.isSuccessful) {
                                navigateToHome(it.result.user?.email ?: "")
                            } else if (it.exception?.toString()
                                    ?.contains(msjError) == true
                            ) {
                                showUsed()
                            } else {
                                showFailedRegister()
                            }
                        } catch (e: FirebaseAuthException) {
                            Toast.makeText(this, "Something woes wrong", Toast.LENGTH_LONG).show()
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
        builder.setPositiveButton("Understand", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


    private fun showUsed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Email Already in Use")
        builder.setMessage("The email you attempt to use is already taken , please choose another.")
        builder.setPositiveButton("Ok, i'll change it", null)
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