package com.rajkishorbgp.intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.rajkishorbgp.intent.R.id.editText

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<TextInputEditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            if (editText.text?.isNotEmpty() == true) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("name", editText.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this@MainActivity,"Enter the name!!!",Toast.LENGTH_SHORT).show()
            }
        }
    }

//
//    InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
//    imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
}