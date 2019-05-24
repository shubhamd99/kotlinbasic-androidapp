package com.example.myfirstkotlinapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonShow.setOnClickListener {
            Log.i("MainActivity", "Button was clicked")
            Toast.makeText(this, "Button was clicked", Toast.LENGTH_SHORT).show()
        }

        btnSndMsg.setOnClickListener {
            val messageString: String = edUserMsg.text.toString()
            // Toast.makeText(this, messageString, Toast.LENGTH_SHORT).show()

            // sending to another activity
            val intent = Intent(this, SecondActivity::class.java)

            // Explict Intent (When we know we are going to second activity)
            intent.putExtra("user_message", messageString)
            startActivity(intent)
        }

        btnShareMsg.setOnClickListener {
            val messageString: String = edUserMsg.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, messageString)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to :"))
        }
    }
}
