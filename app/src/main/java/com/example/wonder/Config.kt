package com.example.wonder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_config.*

class Config : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

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