package com.example.kotlin_retrofit_mvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("userId")
    val userId : String? =null,

    @Expose
    @SerializedName("id")
    val id: String? =null,

    @Expose
    @SerializedName("title")
    val title: String? =null,

    @Expose
    @SerializedName("completed")
    val completed: Boolean? =null
){
    override fun toString(): String {
        return "User(email=$id, username=$title, comp=$completed)"
    }
}
