package com.example.wonder

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_first.*

class First : AppCompatActivity() {


    lateinit var activity : Activity
    lateinit var preference : SharedPreferences
    val pref_show_intro = "Intro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        activity = this
        preference = getSharedPreferences("IntroSlider" , Context.MODE_PRIVATE)

        if(!preference.getBoolean(pref_show_intro,true)){
            startActivity(Intent(activity,MainActivity::class.java))
            finish()
        }

        btn_first.setOnClickListener { goToMainPage() }

    }

    fun goToMainPage(){
        startActivity(Intent(activity,MainActivity::class.java))
        finish()
        val editor = preference.edit()
        editor.putBoolean(pref_show_intro,false)
        editor.apply()
    }
}
