package com.example.fetchfromapi.models

data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: ArrayList<String>
)

data class ProductResponseModel(
    var products: ArrayList<ProductModel> = arrayListOf(),
    var total: Int,
    var skip: Int,
    var limit: Int
)