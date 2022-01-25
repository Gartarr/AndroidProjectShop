package com.example.apkaprojekt

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.TextView


class ActivityCheckout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        initListeners()
        val i = intent
        ReceiveValue()
    }

    lateinit var textViewOrder: TextView

    fun initListeners() {
        textViewOrder = findViewById(R.id.textViewOrder)
    }

    private fun ReceiveValue() {
        val i = intent
        val order = intent.getStringExtra("Order")
        i.putExtra("RESULT","Resulted text");
        textViewOrder.setText(order)
        //Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
    }

    fun callMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun callToShop(view: View) {
        val intent = Intent(this, ActivityShop::class.java)
        startActivity(intent);
        setResult(Activity.RESULT_OK, intent)
    }
}