package com.example.wonder

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class First : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
}
    fun ClickFirst(view: View) {
        var intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
