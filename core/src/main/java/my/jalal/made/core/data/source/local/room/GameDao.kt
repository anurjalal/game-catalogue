package my.jalal.made.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import my.jalal.made.core.data.source.local.entity.GameEntity

@Dao
interface GameDao {
    @Query("SELECT * FROM game")
    fun getAllGame() : Flow<List<GameEntity>>

    @Query("SELECT * FROM game where is_favorite=1")
    fun getFavoriteGame(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: List<GameEntity>)

    @Update
    fun updateFavoriteGame(game: GameEntity)
}