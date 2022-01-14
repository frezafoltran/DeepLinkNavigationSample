package com.foltran.deeplinknavigationsample.module

import com.foltran.feature_sample.navigation.FeatureRouter
import org.koin.dsl.module

object AppDeepLinkRouterModule {
    val instance = module {
        factory {
            HashMap<String, com.foltran.navigation_deeplink.Routable<*, *>>().apply {
                put(FeatureRouter.deepLinkAuthority, FeatureRouter)
            }
        }
    }
}