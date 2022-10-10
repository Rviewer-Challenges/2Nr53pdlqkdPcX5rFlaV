package com.cys.unit_converter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cys.fragmets.DatosFragment
import com.cys.fragmets.LongitudFragment
import com.cys.fragmets.TiempoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        openFragment(TiempoFragment.newInstance())





        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_tiempo -> {
                    val fragment = TiempoFragment.newInstance()
                    openFragment(fragment)
                    Toast.makeText(baseContext, "Tiempo", Toast.LENGTH_LONG).show()
                    true

                }
                R.id.navigation_longitud -> {
                    val fragment = LongitudFragment.newInstance()
                    openFragment(fragment)
                    Toast.makeText(baseContext, "Longitud", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.navigation_artists -> {
                    val fragment = DatosFragment.newInstance()
                    openFragment(fragment)
                    Toast.makeText(baseContext, "Datos", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.navigation_tiempoVivido -> {
                    true
                }
                else -> false
            }
        }





    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }




}