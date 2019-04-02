package com.example.wonder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cardPorquinhos.setOnClickListener(clickListener)
    }

    fun ClickButton2(view: View) {
        var intent: Intent = Intent(this, Config::class.java)
        startActivity(intent)
    }
    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.cardPorquinhos -> ClickLivro()
            R.id.cardPeter -> ClickToast()
        }
    }
    private fun ClickLivro() {
        val intent = Intent(this, Livro::class.java)
        startActivity(intent)
    }
    fun ClickToast() {
        val text = "Em breve"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
    }

