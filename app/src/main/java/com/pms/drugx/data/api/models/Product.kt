package com.pms.mpharm.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product(
    @Expose
@SerializedName("product_id")
val product_id: Int? = null,

    @Expose
    @SerializedName("productname")
    val productname: String? = null,
    @Expose
    @SerializedName("price")
    val price: Double? = null


    ){
        override fun toString(): String {
            return "User(product_id=$product_id, productname=$productname, price=$price)"
        }

}