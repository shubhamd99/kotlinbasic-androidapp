package com.example.myfirstkotlinapplication.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.myfirstkotlinapplication.Constants
import com.example.myfirstkotlinapplication.R
import com.example.myfirstkotlinapplication.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Companion Object example
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonShow.setOnClickListener {
            Log.i(TAG, "Button was clicked")
            // Extension Function
            showToast(getString(R.string.btn_was_clicked), Toast.LENGTH_LONG)
        }


        // Explict Intent (When we know we are going to second activity)
        btnSndMsg.setOnClickListener {
            val messageString: String = edUserMsg.text.toString()
            // showToast(messageString)

            // sending to another activity
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY, messageString)
            startActivity(intent)
        }

        // Implict Intent (Share Outside)
        btnShareMsg.setOnClickListener {
            val messageString: String = edUserMsg.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, messageString)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to :"))
        }

        // Recycler View
        btnRecycleViewDemo.setOnClickListener {

            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
