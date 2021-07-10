package com.example.ntest.netservice

import com.example.ntest.model.Ndata2s
import com.example.ntest.model.Ndatas
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/public.glowday.com/test/app/product.{page}.json")
    suspend fun getList(@Path("page")page: Int): Response<Ndatas>

    @GET("/public.glowday.com/test/app/recommend_product.json")
    suspend fun getRecommendList(): Response<Ndata2s>
}