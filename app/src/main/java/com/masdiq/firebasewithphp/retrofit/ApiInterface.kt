package com.masdiq.firebasewithphp.retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    // create one data
    @FormUrlEncoded
    @POST("send.php?function=sendNotif")
    fun createData(
        @Field("title") title: String,
        @Field("body") body: String,
    ): Call<PostsResponse>
}