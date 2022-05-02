package com.example.basiccomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.lista_de_compras.*

class ListaDeCompras : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.lista_de_compras)

    setUpListeners()
    setUpRecyclerView()
    setUpAutoComplete()
  }

  private fun setUpAutoComplete() {
    val autoTextView = findViewById<AutoCompleteTextView>(R.id.message_edittext)
    val compras = resources.getStringArray(R.array.Compras)
    val adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, compras)
    autoTextView.setAdapter(adapter)
  }

  private fun setUpListeners() {
    send_button.setOnClickListener {
      val newItem = message_edittext.text.toString()

      if (newItem.isEmpty()) {
        Toast.makeText(this, "O campo não pode estar vazio!", Toast.LENGTH_SHORT).show()
      } else {
        message_edittext.setText("")
        val adapter = message_list.adapter
        if (adapter is MessageAdapter) {
          adapter.addItem(newItem)
          message_list.scrollToPosition(adapter.itemCount-1)
        }
      }
    }
    button_voltar.setOnClickListener{
      finish()
    }
  }

  private fun setUpRecyclerView() {
    message_list.layoutManager = LinearLayoutManager(this)
    message_list.adapter = MessageAdapter()
  }
}