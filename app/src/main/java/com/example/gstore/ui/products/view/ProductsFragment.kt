package com.example.gstore.ui.products.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gstore.R
import com.example.gstore.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() {

    //private lateinit var viewModel: ProductsViewModel
    private lateinit var binding: FragmentProductsBinding
    //private lateinit var dbRoom: DbRoom

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false)

        return binding.root
    }

}