package com.example.ntest.netservice

class ApiRepository {
    private val ApiClient = ApiRequest.client

    suspend fun getList(page: Int) = ApiClient?.getList(page = page)
    suspend fun getRecommendList() = ApiClient?.getRecommendList()
}