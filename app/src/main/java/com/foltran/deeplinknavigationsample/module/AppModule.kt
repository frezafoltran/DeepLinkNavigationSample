package com.foltran.deeplinknavigationsample.module

object AppModule {

    val modules = listOf(com.foltran.navigation_deeplink.RouteModule.instance,
        AppDeepLinkRouterModule.instance
    )
}