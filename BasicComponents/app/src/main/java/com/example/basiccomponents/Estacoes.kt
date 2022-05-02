package com.example.basiccomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.estacoes.*

class Estacoes: AppCompatActivity() {

  private lateinit var pager: ViewPager
  private lateinit var tab: TabLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.estacoes)

    pager = findViewById(R.id.viewPager2)
    tab = findViewById(R.id.tabs)

    val adapter = ViewPagerAdapter(supportFragmentManager)

    adapter.addFragment(VeraoFragmento(), "Verão")
    adapter.addFragment(PrimaveraFragmento(), "Primavera")
    adapter.addFragment(InvernoFragmento(), "Inverno")
    adapter.addFragment(OutonoFragmento(), "Outono")

    pager.adapter = adapter

    tab.setupWithViewPager(pager)

    button_back_estacoes.setOnClickListener{
      finish()
    }
  }
}