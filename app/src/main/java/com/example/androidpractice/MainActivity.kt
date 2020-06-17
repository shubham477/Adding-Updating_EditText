package com.example.androidpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done).setOnClickListener{
            addNickName(it)
        }
        findViewById<TextView>(R.id.display_nickname).setOnClickListener {
            updateNickName(it)
        }
    }

    private fun addNickName(view: View){
        val nickname = findViewById<EditText>(R.id.nickname)
        val displayNickName = findViewById<TextView>(R.id.display_nickname)
        displayNickName.text = nickname.text
        nickname.visibility = View.GONE
        view.visibility = View.GONE
        displayNickName.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun updateNickName(view: View){
        val nickname = findViewById<EditText>(R.id.nickname)
        val done_button = findViewById<Button>(R.id.done)
        nickname.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        view.visibility = View.GONE
        nickname.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickname, 0)
    }
}
