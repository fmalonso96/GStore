package com.example.gstore.ui.products.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gstore.R
import com.example.gstore.data.ViewModelFactory
import com.example.gstore.databinding.FragmentProductsBinding
import com.example.gstore.ui.products.adapter.ProductsAdapter
import com.example.gstore.ui.products.viewmodel.ProductsViewModel

class ProductsFragment : Fragment() {

    private lateinit var viewModel: ProductsViewModel
    private lateinit var binding: FragmentProductsBinding
    //private lateinit var dbRoom: DbRoom

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false)

        setupUI()
        setupViewModel()
        setupObservers()
        return binding.root
    }

    private fun setupUI() {
        binding.recyclerViewProducts.layoutManager = GridLayoutManager(context, 2)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory())[ProductsViewModel::class.java]
    }

    private fun setupObservers() {
        viewModel.currentProducts.observe(viewLifecycleOwner) {
            val adapter = ProductsAdapter(it, onClick = {
                //TODO intent al producto expandido
            })
            binding.recyclerViewProducts.adapter = adapter
        }
    }

}