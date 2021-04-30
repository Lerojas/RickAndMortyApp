package com.androidavanzado.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

class ResultNetworkEntity (

    @SerializedName("created")
    var created: String,
    @SerializedName("episode")
    var episode: List<String>,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("location")
    var location: LocationNetworkEntity,
    @SerializedName("name")
    var name: String,
    @SerializedName("origin")
    var origin: OriginNetworkEntity,
    @SerializedName("species")
    var species: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("url")
    var url: String
)