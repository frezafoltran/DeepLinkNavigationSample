package com.foltran.feature_sample.navigation

import com.foltran.navigation_deeplink.Routes
import com.foltran.navigation_deeplink.RouterData
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeatureRouterData(
    val beatle: String?
) : RouterData() {
    companion object {
        val ROUTE_AUTHORITY = Routes.FeatureSample.authority
    }
}