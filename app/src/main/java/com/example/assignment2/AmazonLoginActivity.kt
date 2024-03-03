package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.example.assignment2.databinding.ActivityAmazonLoginBinding

class AmazonLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAmazonLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAmazonLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val styledText = HtmlCompat.fromHtml(getString(R.string.keep_me_signed_in), HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.keepMeSignedInCheckBox.text = styledText
        // Example: Set up a click listener for the sign-in button
        binding.signInButton.setOnClickListener {
            // Handle the sign-in click event
        }
    }
}