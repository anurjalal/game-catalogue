package my.jalal.made.core.data.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import my.jalal.made.core.data.NetworkBoundResource
import my.jalal.made.core.data.Resource
import my.jalal.made.core.data.source.local.LocalDataSource
import my.jalal.made.core.data.source.remote.RemoteDataSource
import my.jalal.made.core.data.source.remote.network.ApiResponse
import my.jalal.made.core.data.source.remote.response.GameResponse
import my.jalal.made.core.domain.model.Game
import my.jalal.made.core.domain.repository.IGameRepository
import my.jalal.made.core.utils.AppExecutors
import my.jalal.made.core.utils.DataMapper

class GameRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGameRepository{
    override fun getAllGames(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GameResponse>>(){
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> = remoteDataSource.getAllGame()

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val gameList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertGame(gameList)
            }
        }.asFlow()

    override fun getFavoriteGame(): Flow<List<Game>> {
        return localDataSource.getFavoriteGame().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteGame(game: Game, state: Boolean) {
        val gameEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(gameEntity, state) }
    }
}