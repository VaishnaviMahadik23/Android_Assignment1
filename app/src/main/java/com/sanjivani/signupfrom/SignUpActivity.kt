package com.sanjivani.signupfrom

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val etName = findViewById<EditText>(R.id.etName)
        val etContact = findViewById<EditText>(R.id.etContact)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // Validate all fields
            if (validateForm(etName, etContact, etEmail, etPassword, etAddress)) {
                // Proceed with submission
                Toast.makeText(this, "Form Submitted Successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields correctly!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateForm(
        name: EditText, contact: EditText, email: EditText, password: EditText, address: EditText
    ): Boolean {
        var isValid = true

        // Validate Name
        if (TextUtils.isEmpty(name.text)) {
            name.error = "Name is required"
            isValid = false
        }

        // Validate Contact (Phone number should be 10 digits)
        if (TextUtils.isEmpty(contact.text) || contact.text.length != 10) {
            contact.error = "Please enter a valid 10-digit phone number"
            isValid = false
        }

        // Validate Email
        if (TextUtils.isEmpty(email.text) || !Patterns.EMAIL_ADDRESS.matcher(email.text).matches()) {
            email.error = "Please enter a valid email address"
            isValid = false
        }

        // Validate Password
        if (TextUtils.isEmpty(password.text) || password.text.length < 6) {
            password.error = "Password should be at least 6 characters"
            isValid = false
        }

        // Validate Address
        if (TextUtils.isEmpty(address.text)) {
            address.error = "Address is required"
            isValid = false
        }

        return isValid
    }
}
