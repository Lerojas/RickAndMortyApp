package com.androidavanzado.rickandmortyapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidavanzado.rickandmortyapp.data.repository.CharacterRepository
import com.androidavanzado.rickandmortyapp.domain.model.Character

class CharacterViewModel (private val characterRepository: CharacterRepository) : ViewModel() {

    var characterData : MutableLiveData<Character?> = characterRepository.liveData

    fun getData(){
        characterRepository.getData()
    }
}