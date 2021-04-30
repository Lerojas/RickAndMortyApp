package com.androidavanzado.rickandmortyapp.data.model


import com.androidavanzado.rickandmortyapp.domain.model.Info
import com.androidavanzado.rickandmortyapp.domain.model.Result
import com.google.gson.annotations.SerializedName

class CharacterNetworkEntity (
    @SerializedName("info")
    var info: Info,

    @SerializedName("results")
    var resultData: ArrayList<Result>
)