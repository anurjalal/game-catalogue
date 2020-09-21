package my.jalal.made.gamecatalogue.detail

import androidx.lifecycle.ViewModel
import my.jalal.made.core.domain.model.Game
import my.jalal.made.core.domain.usecase.GameUseCase

class DetailGameViewModel(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteTourism(game: Game, newStatus:Boolean) =
        gameUseCase.setFavoriteGame(game, newStatus)
}

