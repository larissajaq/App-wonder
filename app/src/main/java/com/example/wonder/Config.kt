package com.example.wonder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_config.*
import kotlin.properties.Delegates

class Config : AppCompatActivity() {

    lateinit var button_vibrar: Button
    var button_vibrarbackground: Int by Delegates.notNull<Int>()
    lateinit var button_vento: Button
    var button_ventobackground: Int by Delegates.notNull<Int>()
    lateinit var button_toque: Button
    var button_toquebackground: Int by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        val sharedPreference: SharedPreference = SharedPreference(this)
        val intval: Int = sharedPreference.getValueInt("intval")
        val intvalvento: Int = sharedPreference.getValueInt("intvalvento")
        val intvaltoque: Int = sharedPreference.getValueInt("intvaltoque")

        button_vibrar = findViewById(R.id.vibrar)
        button_vibrarbackground = intval

        this.changeButtonState(button_vibrar, button_vibrarbackground) // serve para verificar o estado atual do botão conforme o valor salvo

        vibrar.setOnClickListener {
            if (button_vibrarbackground == 2) {
                button_vibrarbackground = 1;
                this.changeButtonState(button_vibrar, button_vibrarbackground)
                sharedPreference.save("intval", button_vibrarbackground)
            } else {
                button_vibrarbackground = 2;
                this.changeButtonState(button_vibrar, button_vibrarbackground)
                sharedPreference.save("intval", button_vibrarbackground)
            }
        }

            button_vento = findViewById(R.id.vento)
            button_ventobackground = intvalvento

            this.changeButtonState(button_vento, button_ventobackground) // serve para veificar o estado atual do botão conforme o valor salvo

            vento.setOnClickListener {
                if (button_ventobackground == 2) {
                    button_ventobackground = 1;
                    this.changeButtonState(button_vento, button_ventobackground)
                    sharedPreference.save("intvalvento", button_ventobackground)
                } else {
                    button_ventobackground = 2;
                    this.changeButtonState(button_vento, button_ventobackground)
                    sharedPreference.save("intvalvento", button_ventobackground)
                }
            }

                button_toque = findViewById(R.id.toque)
                button_toquebackground = intvaltoque

                this.changeButtonState(button_toque, button_toquebackground) // serve para veificar o estado atual do botão conforme o valor salvo

                toque.setOnClickListener {
                    if (button_toquebackground == 2) {
                        button_toquebackground = 1;
                        this.changeButtonState(button_toque, button_toquebackground)
                        sharedPreference.save("intvaltoque", button_toquebackground)
                    } else {
                        button_toquebackground = 2;
                        this.changeButtonState(button_toque, button_toquebackground)
                        sharedPreference.save("intvaltoque", button_toquebackground)
                    }
                }

//
//
//                var button_backgroundtwo: Int = 1;
//
//                var button_changetwo = findViewById(R.id.vento) as Button;
//
//                vento.setOnClickListener {
//                    if (button_backgroundtwo == 2) {
//                        button_changetwo.setBackgroundResource(R.drawable.roundedbutton);
//                        button_backgroundtwo = 1;
//                    } else if (button_backgroundtwo == 1) {
//                        button_changetwo.setBackgroundResource(R.drawable.roundedbuttontwo);
//                        button_backgroundtwo = 2;
//                    }
//                }
//
//                var button_backgroundthree: Int = 1;
//
//                var button_changethree = findViewById(R.id.toque) as Button;
//
//                toque.setOnClickListener {
//                    if (button_backgroundthree == 2) {
//                        button_changethree.setBackgroundResource(R.drawable.roundedbutton);
//                        button_backgroundthree = 1;
//                    } else if (button_backgroundthree == 1) {
//                        button_changethree.setBackgroundResource(R.drawable.roundedbuttontwo);
//                        button_backgroundthree = 2;
//                    }
//                }
            }


        private fun changeButtonState(button: Button, intval: Int) {
            if (intval == 2) {
                button.setBackgroundResource(R.drawable.roundedbuttontwo)
            }
            else {
                button.setBackgroundResource(R.drawable.roundedbutton)
            }
            Log.d("changeButtonState", intval.toString())
        }
}

