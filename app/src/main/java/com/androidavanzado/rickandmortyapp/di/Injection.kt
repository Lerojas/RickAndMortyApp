package com.androidavanzado.rickandmortyapp.di

import com.androidavanzado.rickandmortyapp.data.mappers.CharacterNetworkMapper
import com.androidavanzado.rickandmortyapp.data.repository.CharacterRepository

object Injection {

    private val characterNetworkMapper = CharacterNetworkMapper()
    private val characterRepository = CharacterRepository(characterNetworkMapper)
    fun providerCharacterRepository() = characterRepository
}