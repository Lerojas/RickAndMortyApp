package com.androidavanzado.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

class OriginNetworkEntity (
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)