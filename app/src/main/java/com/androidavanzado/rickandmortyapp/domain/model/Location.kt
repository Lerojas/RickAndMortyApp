package com.androidavanzado.rickandmortyapp.domain.model

import java.io.Serializable

data class Location(
    val name: String,
    val url: String
) : Serializable