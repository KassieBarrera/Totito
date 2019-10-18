package com.example.nuevaapp2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

open class MainActivity : AppCompatActivity() {

    var jugador1 = ArrayList<Int>()
    var jugador2 = ArrayList<Int>()
    var jugador_activo = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btnCliqueado(view: View) {
        val btnSeleccionado = view as Button
        var idCelda = 0

        when (btnSeleccionado.id) {

            R.id.btn1 -> idCelda = 1
            R.id.btn2 -> idCelda = 2
            R.id.btn3 -> idCelda = 3
            R.id.btn4 -> idCelda = 4
            R.id.btn5 -> idCelda = 5
            R.id.btn6 -> idCelda = 6
            R.id.btn7 -> idCelda = 7
            R.id.btn8 -> idCelda = 8
            R.id.btn9 -> idCelda = 9
        }
        partida(idCelda, btnSeleccionado)
    }

    fun partida(id_celda: Int, btnSeleccionado: Button) {
        if (jugador_activo == 1) {
            btnSeleccionado.text = "X"
            btnSeleccionado.setBackgroundColor(Color.BLUE)
            jugador1.add(id_celda)
            jugador_activo = 2
        } else {
            btnSeleccionado.text = "O"
            btnSeleccionado.setBackgroundColor(Color.RED)
            jugador2.add(id_celda)
            jugador_activo = 1
        }
        btnSeleccionado.isEnabled = false
        ganador()
    }

    open fun ganador() {

        var ganador = -1

        //linea1
        if (jugador1.contains(1) && jugador2.contains(2) && jugador1.contains(3)) {
            ganador = 1
        }

        if (jugador2.contains(1) && jugador2.contains(2) && jugador2.contains(3)) {
            ganador = 2
        }

        //Linea2
        if (jugador1.contains(4) && jugador2.contains(5) && jugador1.contains(6)) {
            ganador = 1
        }

        if (jugador2.contains(4) && jugador2.contains(5) && jugador2.contains(6)) {
            ganador = 2
        }

        //linea3
        if (jugador1.contains(7) && jugador2.contains(8) && jugador1.contains(9)) {
            ganador = 1
        }

        if (jugador2.contains(7) && jugador2.contains(8) && jugador2.contains(9)) {
            ganador = 2
        }

        //linea4
        if (jugador1.contains(1) && jugador2.contains(4) && jugador1.contains(7)) {
            ganador = 1
        }

        if (jugador2.contains(1) && jugador2.contains(4) && jugador2.contains(7)) {
            ganador = 2
        }

        //linea5
        if (jugador1.contains(2) && jugador2.contains(5) && jugador1.contains(8)) {
            ganador = 1
        }

        if (jugador2.contains(2) && jugador2.contains(5) && jugador2.contains(8)) {
            ganador = 2
        }

        //linea6
        if (jugador1.contains(3) && jugador2.contains(6) && jugador1.contains(9)) {
            ganador = 1
        }

        if (jugador2.contains(3) && jugador2.contains(6) && jugador2.contains(9)) {
            ganador = 2
        }

        //linea7

        if (jugador1.contains(1) && jugador2.contains(5) && jugador1.contains(9)) {
            ganador = 1
        }

        if (jugador2.contains(1) && jugador2.contains(5) && jugador2.contains(9)) {
            ganador = 2
        }


        if (jugador1.contains(3) && jugador2.contains(5) && jugador1.contains(7)) {
            ganador = 1
        }

        if (jugador2.contains(3) && jugador2.contains(5) && jugador2.contains(7)) {
            ganador = 2
        }

        if (ganador != -1) {
            if (ganador == 1) {
                Toast.makeText(this, "Felicidades jugador 1, has ganado", Toast.LENGTH_SHORT).show()
                /* val superActivityToast = SuperActivityToast(this)
                 superActivityToast.text = "¡Felicidades jugador 1, has ganado!"
                 superActivityToast.duration = Style.DURATION_MEDIUM
                 superActivityToast.color =
                     PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_DEEP_PURPLE)
                 superActivityToast.textColor = Color.WHITE
                 superActivityToast.setTouchToDismiss(true)
                 superActivityToast.isIndeterminate = true
                 superActivityToast.progressIndeterminate = true
                 superActivityToast.show()*/
            } else {
                Toast.makeText(this, "Felicidades jugador 2, has ganado", Toast.LENGTH_SHORT).show()
                /*val superActivityToast = SuperActivityToast(this)
                superActivityToast.text = "¡Felicidades jugador 2, has ganado!"
                superActivityToast.duration = Style.DURATION_MEDIUM
                superActivityToast.color =
                    PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_DEEP_PURPLE)
                superActivityToast.textColor = Color.WHITE
                superActivityToast.setTouchToDismiss(true)
                superActivityToast.isIndeterminate = true
                superActivityToast.progressIndeterminate = true
                superActivityToast.show*/

            }
        }
    }
}
