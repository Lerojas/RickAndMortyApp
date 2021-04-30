package com.androidavanzado.rickandmortyapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidavanzado.rickandmortyapp.data.repository.CharacterRepository

class CharacterViewModelFactory
constructor(private val repository: CharacterRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CharacterViewModel(repository) as T
    }
}