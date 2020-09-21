package my.jalal.made.gamecatalogue.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import my.jalal.made.core.domain.usecase.GameUseCase

class HomeViewModel(gameUseCase: GameUseCase) : ViewModel() {
    val game = gameUseCase.getAllGame().asLiveData()
}

