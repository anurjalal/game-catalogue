package my.jalal.made.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import my.jalal.made.core.data.Resource
import my.jalal.made.core.domain.model.Game
import my.jalal.made.core.domain.repository.IGameRepository

class GameInteractor(private val gameRepository: IGameRepository): GameUseCase {
    override fun getAllGame(): Flow<Resource<List<Game>>> = gameRepository.getAllGames()

    override fun getFavoriteGame(): Flow<List<Game>> = gameRepository.getFavoriteGame()

    override fun setFavoriteGame(game: Game, state: Boolean) = gameRepository.setFavoriteGame(game, state)

}