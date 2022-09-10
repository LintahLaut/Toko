package com.example.toko

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var navigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        changeFragment(FragmentHome())
        navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    changeFragment(FragmentHome())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.menu_pegawai -> {
                    changeFragment(FragmentPegawai())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.menu_barang -> {
                    changeFragment(FragmentBarang())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }

    // Method untuk mengubah fragment
    fun changeFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}