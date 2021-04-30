package com.androidavanzado.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

class InfoNetworkEntity (
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("pages")
    var pages: Int,
    @SerializedName("prev")
    var prev: Any
)