package com.example.uts4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fieldTitle: EditText = findViewById(R.id.field_title)
        val submitButton: Button = findViewById(R.id.tombol_submit)

        // Tombol Submit di-klik
        submitButton.setOnClickListener {
            val name = fieldTitle.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Enter your name first", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("USERNAME", name)
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
