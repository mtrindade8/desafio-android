package com.picpay.desafio.android.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
) : Serializable