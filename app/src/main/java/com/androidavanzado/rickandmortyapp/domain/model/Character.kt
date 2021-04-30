package com.androidavanzado.rickandmortyapp.domain.model

data class Character(
    val info: Info,
    val results: ArrayList<Result>
)