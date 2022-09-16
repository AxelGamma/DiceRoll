package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//Creamos una clase la cual tiene una funcion que devuelve un numero aleatorio
class Dice(val numSides: Int) {
    fun roll(): Int {
        //retornamos en un rando de uno a x y con random damos un numero aleatorio
        return (1..numSides).random()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        //funcion lamda que escucha
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        //instanciamos la clase dice con el numero de lados del dado
        val dice = Dice(6)
        //la variable diceroll llama para generar nuestro numero aleatorio
        val diceRoll = dice.roll()
        //la variable resutTextView busca con findViewById el id del textView
        val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView llama al metodo text el cual va mostrar en textView lo que va mostrar
        //ya que es un string pasamos el numero aleatorio a string con toString()
        resultTextView.text = diceRoll.toString()
    }
}
