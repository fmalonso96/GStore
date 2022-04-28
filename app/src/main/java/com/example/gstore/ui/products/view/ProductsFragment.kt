package com.example.gstore.ui.products.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gstore.R
import com.example.gstore.data.database.DbRoom
import com.example.gstore.utils.ViewModelFactory
import com.example.gstore.databinding.FragmentProductsBinding
import com.example.gstore.ui.products.adapter.ProductsAdapter
import com.example.gstore.ui.products.viewmodel.ProductsViewModel
import com.example.gstore.utils.Communicator

class ProductsFragment : Fragment() {

    private lateinit var viewModel: ProductsViewModel
    private lateinit var binding: FragmentProductsBinding
    private lateinit var dbRoom: DbRoom
    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false)
        dbRoom = DbRoom.getDatabase(requireContext())
        communicator = activity as Communicator

        setupUI()
        setupViewModel()
        setupObservers()
        return binding.root
    }

    private fun setupUI() {
        binding.recyclerViewProducts.layoutManager = GridLayoutManager(context, 2)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(dbRoom))[ProductsViewModel::class.java]
    }

    private fun setupObservers() {
        viewModel.currentProducts.observe(viewLifecycleOwner) { productList ->
            val adapter = ProductsAdapter(productList, onClick = { product ->
                communicator.navigateToProductDetail(product)
            })
            binding.recyclerViewProducts.adapter = adapter
        }
    }
}