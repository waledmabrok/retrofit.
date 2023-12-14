package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface UserApis {


    @GET("products")


    fun getProductById():Call<List<Product>>

}