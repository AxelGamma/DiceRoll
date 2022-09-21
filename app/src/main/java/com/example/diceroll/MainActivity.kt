package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        //Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        //instanciamos la clase dice con el numero de lados del dado
        val dice = Dice(7)
        //la variable diceroll llama para generar nuestro numero aleatorio
        val diceRoll = dice.roll()
        //la variable resutTextView busca con findViewById el id del textView
        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView llama al metodo text el cual va mostrar en textView lo que va mostrar
        //ya que es un string pasamos el numero aleatorio a string con toString()
        //resultTextView.text = diceRoll.toString()

        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResouse = when (diceRoll) {
            1 -> R.drawable.__harry_potter_y_el_c_liz_de_fuego
            2 -> R.drawable.__harry_potter_y_el_misterio_del_pr_ncipe
            3 -> R.drawable.__harry_potter_y_el_prisionero_de_azkaban
            4 -> R.drawable.__harry_potter_y_la_c_mara_secreta
            5 -> R.drawable.__harry_potter_y_la_orden_del_f_nix
            6 -> R.drawable.__harry_potter_y_las_reliquias_de_la_muerte_parte1
            else-> R.drawable.__harry_potter_y_las_reliquias_de_la_muerte_parte2
        }
        diceImage.setImageResource(drawableResouse)
        diceImage.contentDescription = diceRoll.toString()

        textPelicula(diceRoll)
    }

    private fun textPelicula(pelicula: Int) {
        val diceText: TextView = findViewById(R.id.textoPelicula)
        val textView = when (pelicula) {
            1 -> "Harry Potter y el cáliz de fuego"
            2 -> "Harry Potter y el misterio del príncipe"
            3 -> "Harry Potter y el Prisionero de Azkaban"
            4 -> "Harry Potter y la cámara secreta"
            5 -> "Harry Potter y la Orden del Fénix"
            6 -> "Harry Potter y las Reliquias de la Muerte: parte 1"
            else-> "Harry Potter y las Reliquias de la Muerte: parte 2"
        }
        diceText.text=textView
    }
}
