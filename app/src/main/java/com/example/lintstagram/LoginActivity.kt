package com.example.lintstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Check if the user is logged in already
        // If they are, take them Directly to MainActivity

        if (ParseUser.getCurrentUser() != null) {
            goToMainActivity()
        }

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()
            loginUser(username, password)
        }

        findViewById<Button>(R.id.btnSignup).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()
            signUpUser(username, password)
        }
    }

    private fun loginUser(username: String, password: String) {
        ParseUser.logInInBackground(username, password, ({ user, e ->
            if (user != null) {
                // Hooray!  The user is logged in.
                Log.i(TAG, "Successfully logged in user!")
                // Navigate the user to the main activity
                goToMainActivity()

            } else {
                // Signup failed.  Look at the ParseException to see what happened.
                e.printStackTrace()
                Toast.makeText(this, "Error logging in.", Toast.LENGTH_SHORT).show()

            }})
        )
    }

    private fun signUpUser(username: String, password: String) {
        // Create the ParseUser
        val user = ParseUser()

    // Set fields for the user to be created
        user.setUsername(username)
        user.setPassword(password)

        user.signUpInBackground { e ->
            if (e == null) {
                // User has created a new account successfully
                // Hooray! Let them use the app now.

                // Navigate the user to the MainActivity
                goToMainActivity()
                // Show a toast to indicate a user has signed up successfully
                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
            } else {
                // Sign up didn't succeed. Look at the ParseException
                // to figure out what went wrong
                e.printStackTrace()
            }
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        finish() // Closes out the loginactivity
    }
    companion object {
        const val TAG = "LoginActivity"
    }
}