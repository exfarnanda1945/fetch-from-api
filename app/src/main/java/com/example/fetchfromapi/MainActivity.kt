package com.example.fetchfromapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchfromapi.databinding.ActivityMainBinding
import com.example.fetchfromapi.models.ProductResponseModel
import com.example.fetchfromapi.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rvProducts = binding.rvProducts

        rvProducts.setHasFixedSize(true)

        Api.retrofitService.list().enqueue(object : Callback<ProductResponseModel> {
            override fun onResponse(
                call: Call<ProductResponseModel>,
                response: Response<ProductResponseModel>
            ) {
                if (response.isSuccessful) {
                    val result: ProductResponseModel? = response.body()
                    rvProducts.apply {
                        adapter = result?.products?.let { ProductListAdapter(it) }
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponseModel>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}