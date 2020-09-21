package my.jalal.made.gamecatalogue

import android.app.Application
import my.jalal.made.core.di.databaseModule
import my.jalal.made.core.di.networkModule
import my.jalal.made.core.di.repositoryModule
import my.jalal.made.gamecatalogue.di.useCaseModule
import my.jalal.made.gamecatalogue.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}