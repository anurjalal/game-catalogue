package my.jalal.made.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val name: String,
    val releasedDate : String,
    val backgroundImage : String,
    val rating: Double,
    val isFavorite: Boolean
): Parcelable