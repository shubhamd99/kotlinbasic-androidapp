package com.example.myfirstkotlinapplication.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.myfirstkotlinapplication.Constants
import com.example.myfirstkotlinapplication.R
import com.example.myfirstkotlinapplication.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Null Safety Operators ( ?. , ?.let { } )

        val bundle: Bundle? = intent.extras                  // nullable (Bundle?)

        // if null then the code inside will not execute
        bundle?.let {

            val msg = bundle.getString(Constants.USER_MSG_KEY)
            showToast(msg)

            // val txtView = findViewById<TextView>(R.id.textView1)
            // txtView.text = msg.toString()
            textView1.text = msg
        }

    }
}
