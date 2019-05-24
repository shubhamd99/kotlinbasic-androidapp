package com.example.myfirstkotlinapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras                  // nullable (Bundle?)
        val msg = bundle!!.getString("user_message")      // not nullable !!

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        // val txtView = findViewById<TextView>(R.id.textView1)
        // txtView.text = msg.toString()

        textView1.text = msg
    }
}