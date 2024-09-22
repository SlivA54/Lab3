package com.example.lab3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data: TextInputEditText = findViewById(R.id.textInputEditText)
        val data2: TextInputEditText = findViewById(R.id.textInputEditText2)
        val text: TextView = findViewById(R.id.textView)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            try {
                val result = findLastIndexOfChar(data.text.toString(), data2.text.toString())
                text.text = result.toString()
            } catch (e: Exception) {
                text.text = "Error: ${e.message}"
            }
        }
    }

    fun findLastIndexOfChar(input: String, char: String): Int {
        return if (char.isNotEmpty()) {
            input.lastIndexOf(char) + 1
        } else {
            throw IllegalArgumentException("Search character cannot be empty")
        }
    }
}