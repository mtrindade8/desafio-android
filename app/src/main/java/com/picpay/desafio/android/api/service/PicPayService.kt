package com.picpay.desafio.android.api.service

import com.picpay.desafio.android.model.User
import retrofit2.Response
import retrofit2.http.GET


interface PicPayService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}