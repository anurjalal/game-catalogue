package my.jalal.made.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import my.jalal.made.core.data.Resource
import my.jalal.made.core.domain.model.Game

interface GameUseCase {
    fun getAllGame(): Flow<Resource<List<Game>>>
    fun getFavoriteGame(): Flow<List<Game>>
    fun setFavoriteGame(game: Game, state:Boolean)
}