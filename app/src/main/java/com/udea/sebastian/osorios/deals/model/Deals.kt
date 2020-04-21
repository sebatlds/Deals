package com.udea.sebastian.osorios.deals.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Deals(
    @SerializedName("offers")
    val offers: List<Offer>,
    @SerializedName("result")
    val result: Boolean
) : Serializable