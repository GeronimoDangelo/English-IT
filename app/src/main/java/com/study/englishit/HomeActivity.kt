package com.study.englishit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
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
        val provider = bundle?.getString("provider")
        if (email != null && provider != null) {
            setup(email = email, provider = provider)

        }
    }

    private fun setup(email: String, provider: String) {
        binding.tvEmail.text = email
        binding.tvProvider.text = provider
        val btnLogOut = binding.btnLogOut
        btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }

    }

}


enum class ProviderType {
    BASIC,
    COMPLEX
}