package com.example.lab_week_02_b

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

// Keeping the second, more complete declaration of MainActivity
class MainActivity : AppCompatActivity() {
    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
    }

    // It's generally better to initialize views in onCreate or use view binding
    private lateinit var submitButton: Button
    private lateinit var colorCodeInputField: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge() // Call this if you intend to use edge-to-edge

        setContentView(R.layout.activity_main)

        // Initialize views after setContentView
        submitButton = findViewById(R.id.submit_button)
        colorCodeInputField = findViewById(R.id.color_code_input_field)

        /*
        // Optional: If you are using edge-to-edge and want to handle insets
        // Ensure you have a view with android:id="@+id/main" in your activity_main.xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */

        submitButton.setOnClickListener {
            val colorCode = colorCodeInputField.text.toString()
            if (colorCode.isNotEmpty()) {
                if (colorCode.length < 6) {
                    Toast
                        .makeText(
                            this,
                            getString(R.string.color_code_input_wrong_length), // Ensure this string exists
                            Toast.LENGTH_LONG
                        )
                        .show()
                } else {
                    // Ensure ResultActivity is created and declared in AndroidManifest.xml
                    val resultIntent = Intent(this, ResultActivity::class.java)
                    resultIntent.putExtra(COLOR_KEY, colorCode)
                    startActivity(resultIntent)
                }
            } else {
                Toast
                    .makeText(
                        this,
                        getString(R.string.color_code_input_empty), // Ensure this string exists
                        Toast.LENGTH_LONG
                    )
                    .show()
            }
        }
    }
}
