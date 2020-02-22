package com.pms.drugx.api

import com.pms.mpharm.models.Product
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/products/{userId}")
    suspend fun getProducts(
        @Path("userId") userId: String
    ): List<Product>

}