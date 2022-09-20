package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isFirstTime()) {
            showWelcomeToast()
            updateFirstTime()
        }
    }

    private fun isFirstTime(): Boolean {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getBoolean(KEY_FIRST_TIME_APP, true)
    }

    private fun updateFirstTime() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean(KEY_FIRST_TIME_APP, false)
            apply()
        }
    }

    private fun showWelcomeToast() {
        Toast.makeText(this, R.string.dialog_message, Toast.LENGTH_SHORT).show()
    }

    private companion object {
        private const val KEY_FIRST_TIME_APP = "KEY_FIRST_TIME_APP"
    }
}