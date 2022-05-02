package com.example.basiccomponents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  private val items: MutableList<String> = mutableListOf("Arroz", "Feijão")

  fun addItem(newItem: String) {
    items.add(newItem)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val card = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.message_card, parent, false)
    return MessageViewHolder(card)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val currentItem = items[position]
    if (holder is MessageViewHolder) {
      holder.messageTextView.text = currentItem
    }
    holder.itemView.setOnLongClickListener {
      Toast.makeText(holder.itemView.context, "Você clicou no(a) ${items[position]}", Toast.LENGTH_SHORT).show()
      return@setOnLongClickListener true
    }
  }

  override fun getItemCount(): Int {
    return items.size
  }

  class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val messageTextView: TextView = itemView.findViewById(R.id.message_textview)
  }
}