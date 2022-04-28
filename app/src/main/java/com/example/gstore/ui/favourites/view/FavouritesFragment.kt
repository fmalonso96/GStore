package com.example.gstore.ui.favourites.view

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
import com.example.gstore.databinding.FragmentFavouritesBinding
import com.example.gstore.ui.favourites.adapter.FavouritesAdapter
import com.example.gstore.ui.favourites.viewmodel.FavouritesViewModel
import com.example.gstore.utils.Communicator
import com.example.gstore.utils.ViewModelFactory

class FavouritesFragment : Fragment() {

    private lateinit var viewModel: FavouritesViewModel
    private lateinit var binding: FragmentFavouritesBinding
    private lateinit var dbRoom: DbRoom
    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourites, container, false)
        dbRoom = DbRoom.getDatabase(requireContext())
        communicator = activity as Communicator

        setupViewModel()
        setupUI()
        setupObservers()

        return binding.root
    }

    private fun setupUI() {
        binding.recyclerViewFavourites.layoutManager = GridLayoutManager(context, 2)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(dbRoom))[FavouritesViewModel::class.java]
    }

    private fun setupObservers() {
        viewModel.currentFavouriteProducts.observe(this.viewLifecycleOwner) { favouriteList ->
            val adapter = FavouritesAdapter(favouriteList, onClick = { product ->
                communicator.navigateToProductDetail(product)
            })
            binding.recyclerViewFavourites.adapter = adapter
        }
    }

}