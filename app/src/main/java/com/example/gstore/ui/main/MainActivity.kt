package com.example.gstore.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.gstore.R
import com.example.gstore.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(toolbarMain)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbarMain, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        //changeFragment(HomeFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        when (item.itemId) {
            R.id.navProducts -> {
                //changeFragment(HomeFragment())
                setToolbarTitle(item.title.toString())
            }
            R.id.navFavourites -> {
                //changeFragment(ProductsFragment())
                setToolbarTitle(item.title.toString())
            }
            R.id.navConfiguration -> {
                //changeFragment(ConfigurationFragment())
                setToolbarTitle(item.title.toString())
            }
        }
        return true
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun changeFragment(frag: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragmentContainer, frag).commit()
    }

    /**
    override fun navigateToNewProduct() {
        changeFragment(NewProductFragment())
        setToolbarTitle("Nuevo Producto")
    }

    override fun navigateToProducts() {
        changeFragment(ProductsFragment())
        setToolbarTitle("Productos")
    }

    override fun navigateToHome() {
        changeFragment(HomeFragment())
        setToolbarTitle("Menu Principal")
    }
    */
}