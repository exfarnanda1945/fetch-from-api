package com.example.fetchfromapi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fetchfromapi.models.ProductModel

class ProductListAdapter(private val productList: ArrayList<ProductModel>) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProduct: ImageView = view.findViewById(R.id.image_product_list)
        val tvProductName: TextView = view.findViewById(R.id.tv_name_product_list)
        val tvProductBrand: TextView = view.findViewById(R.id.tv_brand_list)
        val tvProductTag: TextView = view.findViewById(R.id.tv_tag_list)
        val tvProductRate: TextView = view.findViewById(R.id.tv_rate_list)
        val tvPrice: TextView = view.findViewById(R.id.tv_price_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_product, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]

        Glide.with(holder.itemView.context).load(item.thumbnail).centerCrop().into(holder.imgProduct)
        holder.tvProductName.text = item.title
        holder.tvProductBrand.text = item.brand
        holder.tvProductTag.text = item.category
        holder.tvProductRate.text = item.rating.toString()
        holder.tvPrice.text = "$${item.price.toString()}"
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}