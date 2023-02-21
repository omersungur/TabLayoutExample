package com.omersungur.tablayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class MainActivity : AppCompatActivity() {

    lateinit var tLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tLayout = tabLayout

        tLayout.addTab(tLayout.newTab())
        tLayout.addTab(tLayout.newTab()) // toplam 2 bölme oluşturduk.

        createTab()

        tLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tabSec(tab!!.position)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    fun tabSec(index : Int) {

        if(index == 0) Toast.makeText(this,"1.Activity",Toast.LENGTH_LONG).show() // tab indeksine göre işlem.
        else if (index == 1) Toast.makeText(this,"2.Activity",Toast.LENGTH_LONG).show()
    }

    private fun createTab() {
        val tab1 = LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
        tab1.tvTitle.text = "Tab1"
        tab1.tvSayi.text = "1"
        tLayout.getTabAt(0)?.customView = tab1 // indeksine göre tab layout bölmelerini alıyoruz

        val tab2 = LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
        tab2.tvTitle.text = "Tab2"
        tab2.tvSayi.text = "2"
        tLayout.getTabAt(1)?.customView = tab2 // 1.indisteki bölüme yani 2.parçadaki bölüme bu tab'ı yerleştirdik.
    }
}