package com.example.basiccomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class VeraoFragmento : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) =
    inflater.inflate(R.layout.fragment_verao, container, false)!!
}