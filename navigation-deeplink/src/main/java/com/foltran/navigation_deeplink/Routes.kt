package com.foltran.navigation_deeplink

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class Routes(val authority: String): Parcelable {
    @Parcelize
    object FeatureSample: Routes(authority = "feature_beatle")
}