package com.androidavanzado.rickandmortyapp.data.network

import com.androidavanzado.rickandmortyapp.data.model.CharacterNetworkEntity
import retrofit2.http.GET

interface RetroService {

    @GET("character")
    fun getCharacterDataFromAPI() : retrofit2.Call<CharacterNetworkEntity>

    /*@GET("api/breed/{breed_name}/images")
    fun getBreedImageDataFromAPI(@Path(value = "breed_name", encoded = true) breedName :  String) : retrofit2.Call<BreedImageNetworkEntity>*/
}