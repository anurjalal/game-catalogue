package my.jalal.made.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
class GameEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name= "name")
    var name: String,
    @ColumnInfo(name = "released_date")
    var releasedDate : String,
    @ColumnInfo(name = "background_image")
    var backgroundImage : String,
    @ColumnInfo(name = "rating")
    var rating: Double,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean
)