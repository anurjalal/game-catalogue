package my.jalal.made.core.utils

import my.jalal.made.core.data.source.local.entity.GameEntity
import my.jalal.made.core.data.source.remote.response.GameResponse
import my.jalal.made.core.domain.model.Game

object DataMapper {

    fun mapResponseToEntities(input: List<GameResponse>): List<GameEntity> {
        val gameList = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                id = it.id,
                name = it.name,
                releasedDate = it.releasedDate,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                isFavorite = false
            )
            gameList.add(game)
        }
        return gameList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                id = it.id,
                name = it.name,
                releasedDate = it.releasedDate,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) = GameEntity(
        id = input.id,
        name = input.name,
        releasedDate = input.releasedDate,
        backgroundImage = input.backgroundImage,
        rating = input.rating,
        isFavorite = input.isFavorite
    )
}