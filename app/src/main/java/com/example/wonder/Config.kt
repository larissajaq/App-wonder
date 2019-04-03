package com.example.wonder

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_config.*

class Config : AppCompatActivity() {

   // val PREFS_FILENAME = "com.teamtreehouse.colorsarefun.prefs"
   // val BUTTON_COLOR = "button_color"
   // var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

      //  prefs = this.getSharedPreferences(PREFS_FILENAME, 0)

      //  val prefs = this.getSharedPreferences(PREFS_FILENAME, 0)
    //    val bgColor = prefs!!.getInt(BUTTON_COLOR, 1)

    var button_background : Int = 1;

    var button_change = findViewById(R.id.vibrar) as Button;

    vibrar.setOnClickListener {
        if(button_background==2){
            button_change.setBackgroundResource(R.drawable.roundedbutton);
            button_background=1;
        } else if(button_background==1){
            button_change.setBackgroundResource(R.drawable.roundedbuttontwo);
            button_background=2;
        }
       // val editor = prefs!!.edit()
       // editor.putInt(BUTTON_COLOR, button_background)
       // editor.apply()
    }
        var button_backgroundtwo : Int = 1;

        var button_changetwo = findViewById(R.id.vento) as Button;

        vento.setOnClickListener {
            if(button_backgroundtwo==2){
                button_changetwo.setBackgroundResource(R.drawable.roundedbutton);
                button_backgroundtwo=1;
            } else if(button_backgroundtwo==1){
                button_changetwo.setBackgroundResource(R.drawable.roundedbuttontwo);
                button_backgroundtwo=2;
            }
        }

        var button_backgroundthree : Int = 1;

        var button_changethree = findViewById(R.id.toque) as Button;

        toque.setOnClickListener {
            if(button_backgroundthree==2){
                button_changethree.setBackgroundResource(R.drawable.roundedbutton);
                button_backgroundthree=1;
            } else if(button_backgroundthree==1){
                button_changethree.setBackgroundResource(R.drawable.roundedbuttontwo);
                button_backgroundthree=2;
            }
        }
}
}