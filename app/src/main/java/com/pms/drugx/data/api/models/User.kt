package com.pms.mpharm.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(

    @Expose
    @SerializedName("user_id")
    val user_id: Int? = null,
    @Expose
    @SerializedName("email")
    val email: String? = null,

    @Expose
    @SerializedName("username")
    val username: String? = null


){
    override fun toString(): String {
        return "User(user_id=$user_id,email=$email, username=$username)"
    }
}