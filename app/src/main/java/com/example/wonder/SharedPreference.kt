package com.example.wonder

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Kolincodes on 10/05/2018.
 */

class SharedPreference(val context: Context) {
    private val Config = "kotlincodes"
    val sharedPref: SharedPreferences = context.getSharedPreferences(Config, Context.MODE_PRIVATE)

    fun save(hello: String, value: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putInt(hello, value)

        editor.commit()
    }
    fun getValueInt(hey: String): Int {

        return sharedPref.getInt(hey, 0)
    }
    fun clearSharedPreference() {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        //sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

        editor.clear()
        editor.commit()
    }

}