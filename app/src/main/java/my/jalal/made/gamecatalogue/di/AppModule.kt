package my.jalal.made.gamecatalogue.di

import my.jalal.made.core.domain.usecase.GameInteractor
import my.jalal.made.core.domain.usecase.GameUseCase
import my.jalal.made.gamecatalogue.detail.DetailGameViewModel
import my.jalal.made.gamecatalogue.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailGameViewModel(get()) }
}