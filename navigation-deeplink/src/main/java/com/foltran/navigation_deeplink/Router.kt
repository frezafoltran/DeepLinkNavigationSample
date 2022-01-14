package com.foltran.navigation_deeplink

import android.content.Context
import android.net.Uri
import android.util.Log


class Router(
    private val routes: HashMap<String, Routable<*, *>>
) {

    fun routeToLink(context: Context?, routeId: String, data: Uri?) {

        routes[routeId]?.startDeepLink(context, data) ?: kotlin.run {
            Log.e(javaClass.simpleName, "authority is invalid")
        }
    }

    fun routeToActivity(context: Context?, authority: String, data: RouterData? = null) {
        routes[authority]?.startActivity(context, data)
    }

    fun routeToActivityByData(context: Context?, data: RouterData?) {
        routes.entries.forEach {
            it.takeIf { it.value.routerDataClass == data?.javaClass }?.value?.startActivity(
                context,
                data
            )
        }
    }
}