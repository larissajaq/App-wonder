package com.example.wonder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cardPorquinhos.setOnClickListener(clickListener)
        cardPeter.setOnClickListener(clickListener)
        cardCinderela.setOnClickListener(clickListener)
        cardAladdin.setOnClickListener(clickListener)
    }

    fun ClickButton2(view: View) {
        var intent: Intent = Intent(this, Config::class.java)
        startActivity(intent)
    }
    fun ClickLog(view: View) {
        Log.d("log", "clicked");
    }
    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.cardPorquinhos -> this.ClickLivro()
            R.id.cardPeter -> this.ClickToast(view)
            R.id.cardCinderela -> this.ClickToast(view)
            R.id.cardAladdin -> this.ClickToast(view)
        }
    }
    private fun ClickLivro() {
        val intent = Intent(this, Livro::class.java)
        startActivity(intent)
    }
    private fun ClickToast(view: View) {
        Toast.makeText(this@MainActivity, "Em breve", Toast.LENGTH_SHORT).show()
    }

    }

