package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners() //Establece los Listeners
    }

    //Función que colorea y/o establece imagen a la caja seleccionada y
    // establece la acción de los botones
    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.image1)

            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)

            // Boxes using custom colors for background
            R.id.red_button -> findViewById<TextView>(R.id.box_three_text).setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> findViewById<TextView>(R.id.box_four_text).setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> findViewById<TextView>(R.id.box_five_text).setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }


    //Función que establece los Listener para cada Box
    private fun setListeners() {

        //Se obtienen las 5 boxes, el constraint layout y los 3 botones indicados
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        //Se hace una lista de vistas con todos los elementos obtenidos
        val clickableViews: List<View> =
            listOf(
                boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton
            )

        //Se establece un listener para cada elemento de la lista
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

}