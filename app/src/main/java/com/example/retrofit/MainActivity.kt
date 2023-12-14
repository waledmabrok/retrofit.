package com.example.myapplicationtwo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Product
import com.example.retrofit.R
import com.example.retrofit.RetrofitClient
import com.example.retrofit.UserApis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myApis = RetrofitClient.retrofit.create(UserApis::class.java)
        val callProduct = myApis.getProductById()


        callProduct.enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                var rec: RecyclerView = findViewById(R.id.recyclerView)
                var respone = response.body()
                rec.adapter = myadapter(respone!!)
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("onFailure Method", t.message.toString())
            }

        }
        )

    }
}

