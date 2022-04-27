package com.example.gstore.ui.products.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import com.bumptech.glide.Glide
import com.example.gstore.databinding.FragmentProductDetailBinding
import com.example.gstore.R
import com.example.gstore.ui.main.view.DESCRIPTION
import com.example.gstore.ui.main.view.ID
import com.example.gstore.ui.main.view.IMAGE
import com.example.gstore.ui.main.view.TITLE
import kotlinx.android.synthetic.main.fragment_product_detail.*

class ProductDetailFragment : Fragment() {

    //private lateinit var viewModel: ProductDetailViewModel
    private lateinit var binding: FragmentProductDetailBinding
    //private lateinit var dbRoom: DbRoom

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)

        setupUI()
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.ivFavourite.setOnClickListener {
            //if no está en la base de datos, agregar y cambiar el icono.
            //Sino, eliminar de la base de datos y cambiar el icono.
        }
    }

    private fun setupUI() {
        val id = arguments?.getInt(ID)
        val title = arguments?.getString(TITLE)
        val description = arguments?.getString(DESCRIPTION)
        val image = arguments?.getString(IMAGE)

        binding.tvProductDetailTitle.text = title
        binding.tvProductDetailDescription.text = description
        Glide.with(this).load(image).into(binding.ivProductDetail)
    }
}