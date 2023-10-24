package devandroid.vinicanallesdev.fastcalculation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val points: Float = 0f
) : Parcelable
