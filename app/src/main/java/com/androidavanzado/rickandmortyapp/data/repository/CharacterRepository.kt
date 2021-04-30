package com.androidavanzado.rickandmortyapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.androidavanzado.rickandmortyapp.data.model.CharacterNetworkEntity
import com.androidavanzado.rickandmortyapp.data.mappers.CharacterNetworkMapper
import com.androidavanzado.rickandmortyapp.data.network.RetroInstance
import com.androidavanzado.rickandmortyapp.data.network.RetroService
import com.androidavanzado.rickandmortyapp.domain.model.Character
import retrofit2.Call
import retrofit2.Response

class CharacterRepository constructor(
    private val characterNetworkMapper : CharacterNetworkMapper
){
    val liveData : MutableLiveData<Character?> = MutableLiveData<Character?>()

    fun getData() {

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getCharacterDataFromAPI()

        call.enqueue(
            object : retrofit2.Callback<CharacterNetworkEntity> {
                override fun onResponse(call: Call<CharacterNetworkEntity>,
                                        response: Response<CharacterNetworkEntity>
                ) {
                    if (response.isSuccessful) {
                        val characterNetworkEntity = response.body()?.let { CharacterNetworkEntity(it.info, response.body()!!.resultData) }
                        liveData.value = characterNetworkMapper.mapFromEntity(characterNetworkEntity!!)
                    }
                    else {
                        liveData.value = null
                    }
                }

                override fun onFailure(call: Call<CharacterNetworkEntity>, t: Throwable) {
                    liveData.value = null
                }
            })
    }
}