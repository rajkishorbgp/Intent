package com.rajkishorbgp.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var editText: TextInputEditText

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.textView)
        textView.text = "Hello, ${intent.getStringExtra("name")}"
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)

        button.setOnClickListener {
            val email =editText.text.toString()
            if (email.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "message/rfc822"
                intent.putExtra(Intent.EXTRA_SUBJECT, "[GitHub]")
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                intent.putExtra(Intent.EXTRA_TEXT, "Hello everyone how are you?")
                startActivity(Intent.createChooser(intent, "Send Email"))
            }else{
                Toast.makeText(this@SecondActivity,"Enter the Email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}