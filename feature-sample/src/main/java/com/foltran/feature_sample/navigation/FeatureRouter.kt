package com.foltran.feature_sample.navigation

import android.content.Context
import android.net.Uri
import android.os.Parcelable
import com.foltran.feature_sample.presentation.FeatureActivity
import com.foltran.navigation_deeplink.Routable


class FeatureRouter {

    companion object :
        Routable<FeatureActivity, FeatureRouterData> {
        override val route: Class<FeatureActivity>
            get() = FeatureActivity::class.java
        override val deepLinkAuthority: String
            get() = FeatureRouterData.ROUTE_AUTHORITY
        override val routerDataClass: Class<FeatureRouterData>
            get() = FeatureRouterData::class.java

        private const val DEFAULT_BEATLE = "john"
        private const val DEEP_LINK_TAG = "beatle"

        override fun startActivity(context: Context?, data: Parcelable?) {

            buildIntent(context).putExtra(Routable.ROUTE_INTENT_DATA,
                data?.takeIf { it.javaClass == routerDataClass }
                    ?: FeatureRouterData(DEFAULT_BEATLE)
            ).also {
                context?.startActivity(it)
            }
        }

        override fun startDeepLink(context: Context?, data: Uri?) {
            startActivity(context, FeatureRouterData(data?.getQueryParameter(DEEP_LINK_TAG)))
        }
    }
}