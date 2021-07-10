package com.example.ntest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Ndatas (
    @SerializedName("products")
    val products: List<Ndata1>?,
)

data class Ndata1 (

    @SerializedName("idProduct")
    val idProduct: Int?,

    @SerializedName("idBrand")
    val idBrand: Int?,

    @SerializedName("productTitle")
    val productTitle: String?,

    @SerializedName("volume")
    val volume: String?,

    @SerializedName("price")
    val price: Int?,

    @SerializedName("productScore")
    val productScore: Int?,

    @SerializedName("ratingAvg")
    val ratingAvg: Float?,

    @SerializedName("productRank")
    val productRank: String?,

    @SerializedName("rankChange")
    val rankChange: String?,

    @SerializedName("rankChangeType")
    val rankChangeType: String?,

    @SerializedName("reviewCount")
    val reviewCount: String?,

    @SerializedName("imageUrl")
    val imageUrl: String?,

    @SerializedName("brand")
    val brand: Brand?,

):Serializable

data class Brand(
    @SerializedName("idBrand")
    val idBrand: Int?,

    @SerializedName("brandTitle")
    val brandTitle: String?,

    @SerializedName("imageUrl")
    val imageUrl: String?,

):Serializable

data class Ndata2(
    @SerializedName("idProduct")
    val idProduct: Int?,

    @SerializedName("productTitle")
    val productTitle: String?,

    @SerializedName("ratingAvg")
    val ratingAvg: Float?,

    @SerializedName("reviewCount")
    val reviewCount: String?,

    @SerializedName("imageUrl")
    val imageUrl: String?,

)