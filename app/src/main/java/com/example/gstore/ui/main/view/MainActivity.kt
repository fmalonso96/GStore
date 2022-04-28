package com.example.gstore.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.gstore.R
import com.example.gstore.data.model.Product
import com.example.gstore.databinding.ActivityMainBinding
import com.example.gstore.ui.configuration.view.ConfigurationFragment
import com.example.gstore.ui.favourites.view.FavouritesFragment
import com.example.gstore.ui.products.view.ProductDetailFragment
import com.example.gstore.ui.products.view.ProductsFragment
import com.example.gstore.utils.Communicator
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.navView
import kotlinx.android.synthetic.main.activity_main.drawerLayout
import kotlinx.android.synthetic.main.app_bar_main.*

const val ID = "id"
const val TITLE = "title"
const val DESCRIPTION = "description"
const val IMAGE = "image"

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, Communicator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(toolbarMain)

        setDrawer()
        setNavigationListeners()
        setToolbarTitle("Menu Principal")
        changeFragment(HomeFragment())
    }

    private fun setDrawer() {
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbarMain, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setNavigationListeners() {
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        when (item.itemId) {
            R.id.navHome -> {
                changeFragment(HomeFragment())
                setToolbarTitle(item.title.toString())
            }
            R.id.navProducts -> {
                changeFragment(ProductsFragment())
                setToolbarTitle(item.title.toString())
            }
            R.id.navFavourites -> {
                changeFragment(FavouritesFragment())
                setToolbarTitle(item.title.toString())
            }
            R.id.navConfiguration -> {
                changeFragment(ConfigurationFragment())
                setToolbarTitle(item.title.toString())
            }
        }
        return true
    }

    private fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun changeFragment(frag: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragmentContainer, frag).commit()
    }

    override fun navigateToProductDetail(product: Product) {
        val bundle = Bundle()
        bundle.putInt(ID, product.id)
        bundle.putString(TITLE, product.title)
        bundle.putString(DESCRIPTION, product.description)
        bundle.putString(IMAGE, product.image)
        val productDetailFragment = ProductDetailFragment()
        productDetailFragment.arguments = bundle

        changeFragment(productDetailFragment)
        setToolbarTitle("Detalle del Producto")
    }
}