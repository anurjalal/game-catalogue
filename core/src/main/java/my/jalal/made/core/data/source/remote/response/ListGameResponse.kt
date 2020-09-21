package my.jalal.made.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class ListGameResponse(
    @field:SerializedName("next")
    val next: String?,
    @field:SerializedName("previous")
    val previous : String?,
    @field:SerializedName("results")
    val results: List<GameResponse>
)