package com.cys.unit_converter
/**
 * Author: Sara Corrales Santos
 */
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cys.fragmets.DatosFragment
import com.cys.fragmets.EdadFragment
import com.cys.fragmets.LongitudFragment
import com.cys.fragmets.TiempoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    /**
     * This is the main class, it is in charge of showing the fragments that
     * we select and of creating the menu from which we can choose what time of data
     * we want to convert.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        openFragment(TiempoFragment.newInstance())

        //fragment selection
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_tiempo -> {
                    val fragment = TiempoFragment.newInstance()
                    openFragment(fragment)
                    true

                }
                R.id.navigation_longitud -> {
                    val fragment = LongitudFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.navigation_artists -> {
                    val fragment = DatosFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.navigation_edad -> {
                    val fragment = EdadFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    //Shows the selected fragment in the menu
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}