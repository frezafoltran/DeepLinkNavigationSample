package com.foltran.navigation_deeplink

import org.koin.dsl.module

object RouteModule {
    val instance = module {
        single {
            Router(routes = get())
        }
    }
}