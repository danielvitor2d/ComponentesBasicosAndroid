package com.example.basiccomponents

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setUpListeners()
  }
  fun setUpListeners() {
    button_compras.setOnClickListener{
      val intent = Intent(this, ListaDeCompras::class.java)
      startActivity(intent)
    }
    button_perfil.setOnClickListener{
      val intent = Intent(this, Perfil::class.java)
      startActivity(intent)
    }
    button_estacoes.setOnClickListener{
      val intent = Intent(this, Estacoes::class.java)
      startActivity(intent)
    }
  }
}