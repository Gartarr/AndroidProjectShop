package com.example.apkaprojekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun callToAutor(view: View) {
        val intent = Intent(this, ActivityAuthor::class.java)
        startActivity(intent)
    }
    fun callToShop(view: View) {
        val intent = Intent(this, ActivityShop::class.java)
        startActivity(intent);
    }
}