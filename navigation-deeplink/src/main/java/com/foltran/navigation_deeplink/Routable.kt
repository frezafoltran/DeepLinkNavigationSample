package com.foltran.navigation_deeplink

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Parcelable
import android.util.Log

interface Routable<Route : Activity, Data : RouterData> {

    companion object {
        const val ROUTE_INTENT_DATA = "RouteIntentData"
        const val DEEP_LINK_DATA = "DeepLinkData"
    }

    val route: Class<Route>
    val routerDataClass: Class<Data>
    val deepLinkAuthority: String

    fun startDeepLink(context: Context?, data: Uri?) {
        buildIntent(context).putExtra(DEEP_LINK_DATA, data).also {
            context?.startActivity(it)
        }
    }

    fun startActivity(context: Context?, data: Parcelable?) {
        data?.takeIf { it.javaClass == routerDataClass }?.let { routerData ->
            buildIntent(context).putExtra(ROUTE_INTENT_DATA, routerData).also {
                context?.startActivity(it)
            }
        } ?: kotlin.run {
            Log.e(javaClass.simpleName, "data is not valid")
        }
    }

    fun buildIntent(context: Context?, vararg flags: Int) = Intent(context, route).apply {
        flags.forEach {
            addFlags(it)
        }
    }
}