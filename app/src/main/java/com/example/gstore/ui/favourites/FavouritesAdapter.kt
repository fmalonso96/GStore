package com.example.gstore.ui.favourites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gstore.R
import com.example.gstore.data.model.Product
import com.example.gstore.databinding.ItemRecyclerBinding

class FavouritesAdapter(private val products: List<Product>):
    RecyclerView.Adapter<FavouritesAdapter.FavouriteViewHolder>() {

    class FavouriteViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val binding = ItemRecyclerBinding.bind(view)

        fun bind(product: Product) {
            Glide.with(this.itemView.context).load(product.image).into(binding.ivProduct)
            binding.tvProductTitle.text = product.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavouriteViewHolder(layoutInflater.inflate(R.layout.item_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.size
}