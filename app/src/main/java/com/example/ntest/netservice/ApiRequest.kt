package com.example.ntest.netservice

object ApiRequest {
    private const val API_URL = "https://s3.ap-northeast-2.amazonaws.com"

    val client = BaseService().getClient(API_URL)?.create(ApiService::class.java)
}