package kmm.rickandmorty.app.data.datasource.mapper

import kmm.rickandmorty.app.data.datasource.remote.model.CharactersApiModel
import kmm.rickandmorty.app.data.model.CharacterDataModel
import kmm.rickandmorty.app.data.model.CharacterDataModel.CharacterLocation
import kmm.rickandmorty.app.data.model.CharacterDataModel.CharacterOrigin

fun CharactersApiModel.toData(): Collection<CharacterDataModel> =
    results?.map { character ->
        CharacterDataModel(
            created = character.created.orEmpty(),
            episode = character.episode ?: emptyList(),
            gender = character.gender.orEmpty(),
            id = character.id ?: 0,
            image = character.image.orEmpty(),
            location = CharacterLocation(
                name = character.location?.name.orEmpty(),
                url = character.location?.url.orEmpty()
            ),
            name = character.name.orEmpty(),
            origin = CharacterOrigin(
                character.origin?.name.orEmpty(),
                character.origin?.url.orEmpty()
            ),
            species = character.species.orEmpty(),
            status = character.species.orEmpty(),
            type = character.type.orEmpty(),
            url = character.url.orEmpty()
        )
    } ?: emptyList()
