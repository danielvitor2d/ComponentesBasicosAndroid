package com.example.basiccomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class PrimaveraFragmento : Fragment() {
  // inflate the layout
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) =
    inflater.inflate(R.layout.fragment_primavera, container, false)!!
}