package com.example.gstore.ui.products.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.gstore.databinding.FragmentProductDetailBinding
import com.example.gstore.R
import com.example.gstore.data.database.DbRoom
import com.example.gstore.data.model.Product
import com.example.gstore.ui.main.view.DESCRIPTION
import com.example.gstore.ui.main.view.ID
import com.example.gstore.ui.main.view.IMAGE
import com.example.gstore.ui.main.view.TITLE
import com.example.gstore.ui.products.viewmodel.ProductDetailViewModel
import com.example.gstore.utils.ViewModelFactory

private const val EMPTY_INT = 0
private const val EMPTY_STRING = ""

class ProductDetailFragment : Fragment() {

    private lateinit var viewModel: ProductDetailViewModel
    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var currentProduct: Product
    private lateinit var dbRoom: DbRoom

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)
        dbRoom = DbRoom.getDatabase(requireContext())
        currentProduct = receiveProduct()

        setupViewModel()
        setupUI()
        setupObserver()
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.ivFavourite.setOnClickListener {
            if (viewModel.currentIsFavourite.value == false) {
                viewModel.insertFavourite(currentProduct)
                binding.ivFavourite.setImageResource(R.drawable.ic_favourite_selected)
            } else {
                viewModel.deleteFavourite(currentProduct.id)
                binding.ivFavourite.setImageResource(R.drawable.ic_favourite_unselected)
            }

        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(dbRoom))[ProductDetailViewModel::class.java]
    }

    private fun setupUI() {
        binding.tvProductDetailTitle.text = currentProduct.title
        binding.tvProductDetailDescription.text = currentProduct.description
        Glide.with(this).load(currentProduct.image).into(binding.ivProductDetail)
        viewModel.getIsFavourite(currentProduct.id)
    }

    private fun setupObserver() {
        viewModel.currentIsFavourite.observe(this.viewLifecycleOwner) { isFavourite ->
            if (isFavourite) {
                binding.ivFavourite.setImageResource(R.drawable.ic_favourite_selected)
            }
        }
    }

    private fun receiveProduct(): Product {
        val id = arguments?.getInt(ID)
        val title = arguments?.getString(TITLE)
        val description = arguments?.getString(DESCRIPTION)
        val image = arguments?.getString(IMAGE)
        val product = if (id != null && title != null && description != null && image != null) {
            Product(id, title, description, image)
        } else {
            Product(EMPTY_INT, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING)
        }
        return product
    }
}