package com.study.englishit.ui.views.homeActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.study.englishit.R
import com.study.englishit.databinding.ActivityHomeBinding
import com.study.englishit.util.Constants.USER_EMAIL_FB


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_EnglishIT)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setup
        val bundle = intent.extras
        val email = bundle?.getString(USER_EMAIL_FB)

        if (email != null ) {
            setup(email = email)
        }
    }

    private fun setup(email: String) {
        binding.tvEmail.text = email
        val btnLogOut = binding.btnLogOut
        //sign out
        btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }

    }

}


