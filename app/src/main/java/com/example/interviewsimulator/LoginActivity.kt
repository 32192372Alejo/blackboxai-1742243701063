package com.example.interviewsimulator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.interviewsimulator.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            btnClose.setOnClickListener {
                finish()
            }

            btnLogin.setOnClickListener {
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()

                if (validateInputs(email, password)) {
                    performLogin(email, password)
                }
            }

            btnRegister.setOnClickListener {
                // Navigate to Register screen
                // Intent to RegisterActivity can be added here
            }

            tvForgotPassword.setOnClickListener {
                // Navigate to Forgot Password screen
                // Intent to ForgotPasswordActivity can be added here
            }

            btnFacebook.setOnClickListener {
                // Implement Facebook login
                Toast.makeText(this@LoginActivity, "Facebook login clicked", Toast.LENGTH_SHORT).show()
            }

            btnGoogle.setOnClickListener {
                // Implement Google login
                Toast.makeText(this@LoginActivity, "Google login clicked", Toast.LENGTH_SHORT).show()
            }

            btnLinkedin.setOnClickListener {
                // Implement LinkedIn login
                Toast.makeText(this@LoginActivity, "LinkedIn login clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {
        var isValid = true

        if (email.isEmpty()) {
            binding.tilEmail.error = "El correo electrónico es requerido"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Ingrese un correo electrónico válido"
            isValid = false
        } else {
            binding.tilEmail.error = null
        }

        if (password.isEmpty()) {
            binding.tilPassword.error = "La contraseña es requerida"
            isValid = false
        } else if (password.length < 6) {
            binding.tilPassword.error = "La contraseña debe tener al menos 6 caracteres"
            isValid = false
        } else {
            binding.tilPassword.error = null
        }

        return isValid
    }

    private fun performLogin(email: String, password: String) {
        // Implement your login logic here
        // This could be a call to your authentication service
        Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_SHORT).show()
    }
}
