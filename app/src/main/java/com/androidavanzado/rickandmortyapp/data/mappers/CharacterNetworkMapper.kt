package com.androidavanzado.rickandmortyapp.data.mappers

import com.androidavanzado.rickandmortyapp.data.model.CharacterNetworkEntity
import com.androidavanzado.rickandmortyapp.domain.util.EntityMapper
import com.androidavanzado.rickandmortyapp.domain.model.Character
import javax.inject.Inject

class CharacterNetworkMapper
@Inject
constructor() : EntityMapper<CharacterNetworkEntity, Character> {
    override fun mapFromEntity(entity: CharacterNetworkEntity): Character {
        return Character(
            info = entity.info,
            results = entity.resultData
        )
    }

    override fun mapToEntity(domainModel: Character): CharacterNetworkEntity {
        return CharacterNetworkEntity(
            info = domainModel.info,
            resultData = domainModel.results
        )
    }


}