package com.androidavanzado.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

class LocationNetworkEntity (
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)