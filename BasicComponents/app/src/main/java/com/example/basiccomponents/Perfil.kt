package com.example.basiccomponents

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.lista_de_compras.view.*
import kotlinx.android.synthetic.main.perfil.*

class Perfil: AppCompatActivity() {
  var darkMode = true

  val idades = (1..120).toList()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.perfil)

    setUpSpinner()

    setUpListeners()
  }

  private fun setUpListeners() {
    toggle_button_on.setOnClickListener{
      if (!darkMode) {
        tela_perfil.setBackgroundColor(Color.WHITE)
      } else {
        tela_perfil.setBackgroundColor(Color.BLACK)
      }
      darkMode = !darkMode
    }
    button_back.setOnClickListener{
      finish()
    }
  }

  private fun setUpSpinner() {
    val arrayAdapter = ArrayAdapter<Int>(this, R.layout.spinner_item, idades)
    spinner_idades.adapter = arrayAdapter

    spinner_idades.onItemSelectedListener = object :
      AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>,
                                  view: View, position: Int, id: Long) {
        Toast.makeText(parent.context, "Sua idade é: ${spinner_idades.selectedItem}", Toast.LENGTH_SHORT).show()
      }

      override fun onNothingSelected(parent: AdapterView<*>) {

      }
    }
  }

  fun radio_button_click(view: View) {
    val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
    Toast.makeText(applicationContext,"Cor selecionada : ${radio.text}",
      Toast.LENGTH_SHORT).show()
  }
}