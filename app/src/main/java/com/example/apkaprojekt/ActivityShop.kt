package com.example.apkaprojekt

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged

import kotlinx.android.synthetic.main.activity_shop.*


class ActivityShop : AppCompatActivity() {

    lateinit var friesEdit: EditText
    lateinit var burgerEdit: EditText
    lateinit var cheeseEdit: EditText
    lateinit var chocoEdit: EditText
    lateinit var vaniEdit: EditText
    lateinit var coffeeEdit: EditText
    lateinit var cokeEdit: EditText
    lateinit var sumView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        initListeners()
    }

    fun initListeners() {
        friesEdit = findViewById(R.id.editTextFries)
        burgerEdit = findViewById(R.id.editTextHamburger)
        cheeseEdit = findViewById(R.id.editTextCheeseburger)
        chocoEdit = findViewById(R.id.editTextShakeChoco)
        vaniEdit = findViewById(R.id.editTextShakeVan)
        coffeeEdit = findViewById(R.id.editTextCoffee)
        cokeEdit = findViewById(R.id.editTextCoke)
        sumView = findViewById(R.id.textViewSum)
    }

    fun checkSumButton(view: View) {
        addToSum(view)
        var total = addToSum(view)
        if(total==0) {
            Toast.makeText(applicationContext, getString(R.string.emptyCart), Toast.LENGTH_SHORT).show()
        }
    }

    fun addToSum(view: View) : Int{
        var sum = 0
        if (checkBoxFries.isChecked) {
            if(friesEdit.text.isNotEmpty()) sum+= friesEdit.text.toString().toInt() * 4}
        if (checkBoxHamburger.isChecked) {
            if(burgerEdit.text.isNotEmpty()) sum+= burgerEdit.text.toString().toInt() * 7}
        if (checkBoxCheeseburger.isChecked) {
            if(cheeseEdit.text.isNotEmpty()) sum+= cheeseEdit.text.toString().toInt() * 6}
        if (checkBoxShakeChoco.isChecked) {
            if(chocoEdit.text.isNotEmpty()) sum+= chocoEdit.text.toString().toInt() * 8}
        if (checkBoxVaniShake.isChecked) sum+= vaniEdit.text.toString().toInt() * 8
        if (checkBoxCoffee.isChecked) sum+= coffeeEdit.text.toString().toInt() * 6
        if (checkBoxCoke.isChecked) sum+= cokeEdit.text.toString().toInt() * 5
        sumView.text = ""+sum+" zł"
        return sum
    }


    fun FriesEnable(view: View) {
        if(checkBoxFries.isChecked())
        {
            editTextFries.visibility = View.VISIBLE
        }
        else
        {
            editTextFries.visibility = View.INVISIBLE
        }
        addToSum(view)
    }



    fun BurgerEnable(view: View) {

        if(checkBoxHamburger.isChecked())
        {
            editTextHamburger.visibility = View.VISIBLE
        }
        else
        {
            editTextHamburger.visibility = View.INVISIBLE
        }
        addToSum(view)
    }
    fun CheeseEnable(view: View) {

        if(checkBoxCheeseburger.isChecked())
        {
            editTextCheeseburger.visibility = View.VISIBLE
        }
        else
        {
            editTextCheeseburger.visibility = View.INVISIBLE
        }
        addToSum(view)
    }
    fun ChocoEnable(view: View) {

        if(checkBoxShakeChoco.isChecked())
        {
            editTextShakeChoco.visibility = View.VISIBLE
        }
        else
        {
            editTextShakeChoco.visibility = View.INVISIBLE
        }
        addToSum(view)
    }
    fun CoffeeEnable(view: View) {

        if(checkBoxCoffee.isChecked())
        {
            editTextCoffee.visibility = View.VISIBLE
        }
        else
        {
            editTextCoffee.visibility = View.INVISIBLE
        }
        addToSum(view)
    }
    fun VaniEnable(view: View) {

        if(checkBoxVaniShake.isChecked())
        {
            editTextShakeVan.visibility = View.VISIBLE
        }
        else
        {
            editTextShakeVan.visibility = View.INVISIBLE
        }
        addToSum(view)
    }
    fun CokeEnable(view: View) {

        if(checkBoxCoke.isChecked())
        {
            editTextCoke.visibility = View.VISIBLE
        }
        else
        {
            editTextCoke.visibility = View.INVISIBLE
        }
        addToSum(view)
    }

    fun callCheckout(view: View) {
        var pom = 0
        var v1: String = getString(R.string.orderComplete)
        if (checkBoxFries.isChecked)
        {
            v1+= "\n" + getString(R.string.friesPom) + " " +friesEdit.text.toString() + " x"
            pom++
        }
        if (checkBoxHamburger.isChecked)
        {
            v1+= "\n" + getString(R.string.hamPom) + " " +burgerEdit.text.toString() + " x"
            pom++
        }
        if (checkBoxCheeseburger.isChecked)
        {
            v1+= "\n" + getString(R.string.cheesePom) + " " +cheeseEdit.text.toString() + " x"
            pom++
        }
        if (checkBoxShakeChoco.isChecked)
        {
            v1+= "\n" + getString(R.string.chocoPom) + " " +chocoEdit.text.toString() + " x"
            pom++
        }
        if (checkBoxVaniShake.isChecked)
        {
            v1+= "\n" + getString(R.string.vaniPom) + " " +vaniEdit.text.toString() + " x"
            pom++
        }
        if (checkBoxCoffee.isChecked)
        {
            v1+= "\n" + getString(R.string.coffeePom) + " " +coffeeEdit.text.toString() + " x"
            pom++
        }
        if (checkBoxCoke.isChecked)
        {
            v1+= "\n" + getString(R.string.cokePom) + " " +cokeEdit.text.toString() + " x"
            pom++
        }
        if(pom==0) {
            v1 = getString(R.string.emptyCart)
        }
        v1+= "\n" + addToSum(view).toString() + " zł"
        val runSecondIntent = Intent(this, ActivityCheckout::class.java)
            runSecondIntent.putExtra("Order", v1)
            startActivity(runSecondIntent)

    }
    fun callMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}