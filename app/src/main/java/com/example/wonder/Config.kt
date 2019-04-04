package com.example.wonder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_config.*
import kotlin.properties.Delegates

class Config : AppCompatActivity() {

    lateinit var button_change: Button
    var button_background: Int by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        val sharedPreference: SharedPreference = SharedPreference(this)

        if (sharedPreference.getValueInt("intval") != 0) {
            button_background = sharedPreference.getValueInt("intval")
            Toast.makeText(this@Config, "Data Retrieved", Toast.LENGTH_SHORT).show()
        } else {
            button_background = 1
            sharedPreference.save("intval", 1)
            Toast.makeText(this@Config, "Data Retrie", Toast.LENGTH_SHORT).show()
        }

        button_change = findViewById(R.id.vibrar)

        vibrar.setOnClickListener {
            if (button_background == 2) {
                button_change.setBackgroundResource(R.drawable.roundedbutton);
                button_background = 1;
                sharedPreference.save("intval", 1)
                Toast.makeText(this@Config, "Data Stored", Toast.LENGTH_SHORT).show()
            } else if (button_background == 1) {
                button_change.setBackgroundResource(R.drawable.roundedbuttontwo);
                button_background = 2;
                sharedPreference.save("intval", 2)
                Toast.makeText(this@Config, "Data Saved", Toast.LENGTH_SHORT).show()
            }



                var button_backgroundtwo: Int = 1;

                var button_changetwo = findViewById(R.id.vento) as Button;

                vento.setOnClickListener {
                    if (button_backgroundtwo == 2) {
                        button_changetwo.setBackgroundResource(R.drawable.roundedbutton);
                        button_backgroundtwo = 1;
                    } else if (button_backgroundtwo == 1) {
                        button_changetwo.setBackgroundResource(R.drawable.roundedbuttontwo);
                        button_backgroundtwo = 2;
                    }
                }

                var button_backgroundthree: Int = 1;

                var button_changethree = findViewById(R.id.toque) as Button;

                toque.setOnClickListener {
                    if (button_backgroundthree == 2) {
                        button_changethree.setBackgroundResource(R.drawable.roundedbutton);
                        button_backgroundthree = 1;
                    } else if (button_backgroundthree == 1) {
                        button_changethree.setBackgroundResource(R.drawable.roundedbuttontwo);
                        button_backgroundthree = 2;
                    }
                }
            }
        }
    }

