package com.example.myfirstkotlinapplication

import android.app.Activity
import android.content.Context
import android.widget.Toast

// Extension Function
// duration is default parameter
fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {

    Toast.makeText(this, message, duration).show()
}