package com.example.lab8_kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)
        val btnSend = findViewById<Button>(R.id.btnSend)
        val edName = findViewById<EditText>(R.id.edName)
        val edPhone = findViewById<EditText>(R.id.edPhone)
        btnSend.setOnClickListener {
            when {
                edName.length() < 1 -> showToast("請輸入姓名")
                edPhone.length() < 1 -> showToast("請輸入電話")
                else -> {
                    val b = Bundle()
                    b.putString("name", edName.text.toString())
                    b.putString("phone", edPhone.text.toString())
                    setResult(Activity.RESULT_OK, Intent().putExtras(b))
                    finish()
                }
            }
        }
    }
    private fun showToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}