package com.example.lab_week_02_b

import android.graphics.Color
import android.widget.Toast
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ResultActivity : AppCompatActivity() {
    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if(intent != null){
            val colorCode = intent.getStringExtra(COLOR_KEY)
            if (colorCode != null && colorCode.isNotEmpty()) { // Added null/empty check
                val backgroundScreen =
                    findViewById<ConstraintLayout>(R.id.background_screen)
                try {
                    backgroundScreen.setBackgroundColor(Color.parseColor("#$colorCode"))
                } catch (e: IllegalArgumentException) {
                    // Optionally, handle invalid color code, e.g., show a Toast or set a default color
                    Toast.makeText(this, getString(R.string.color_code_input_invalid), Toast.LENGTH_LONG).show()
                    // You might want to set a default background color here as well
                    // backgroundScreen.setBackgroundColor(Color.GRAY) 
                }
            }

            val resultMessage =
                findViewById<TextView>(R.id.color_code_result_message)
            resultMessage.text = getString(R.string.color_code_result_message,
                colorCode?.uppercase() ?: "XXXXXX") // Added fallback for colorCode
        }
    }
}