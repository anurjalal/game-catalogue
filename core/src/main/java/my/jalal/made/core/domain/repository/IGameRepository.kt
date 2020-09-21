package my.jalal.made.core.domain.repository

import kotlinx.coroutines.flow.Flow
import my.jalal.made.core.data.Resource
import my.jalal.made.core.domain.model.Game

interface IGameRepository {
    fun getAllGames(): Flow<Resource<List<Game>>>

    fun getFavoriteGame(): Flow<List<Game>>

    fun setFavoriteGame(game: Game, state:Boolean)
}