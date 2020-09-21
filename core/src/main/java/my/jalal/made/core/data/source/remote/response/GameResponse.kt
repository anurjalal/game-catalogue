package my.jalal.made.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(
    val id: Int,
    val name: String,
    @field:SerializedName("released")
    val releasedDate : String,
    @field:SerializedName("background_image")
    val backgroundImage : String,
    @field:SerializedName("rating")
    val rating: Double,
    @field:SerializedName("next")
    val description: String
)