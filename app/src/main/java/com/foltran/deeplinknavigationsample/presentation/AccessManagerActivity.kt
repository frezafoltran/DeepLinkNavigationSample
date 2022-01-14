package com.foltran.deeplinknavigationsample.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.foltran.deeplinknavigationsample.R
import com.foltran.navigation_deeplink.Router
import com.foltran.navigation_deeplink.RouterData
import com.foltran.navigation_deeplink.Routes
import org.koin.android.ext.android.inject

class AccessManagerActivity : AppCompatActivity() {

    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access_manager)

        val incomingState = intent.getParcelableExtra(ARG_ROUTE) as? Routes
        val incomingData = intent.getParcelableExtra(ARG_DATA) as? RouterData

        Handler().postDelayed({
            handleState(incomingState, incomingData)
        }, 1000)
    }

    private fun handleState(incomingState: Routes? = null, incomingData: RouterData? = null) {

        incomingState?.let {
            router.routeToActivity(this, incomingState.authority, incomingData)
        } ?: intent.data?.let { data ->
            router.routeToLink(this, data.authority.toString(), data)
        } ?: kotlin.run {
            routeToDefaultState()
        }
        finish()
    }

    private fun routeToDefaultState() {
        router.routeToActivity(
            this,
            Routes.FeatureSample.authority
        )
    }

    companion object {
        const val ARG_ROUTE = "ArgRoute"
        const val ARG_DATA = "ArgData"

        fun newIntent(
            context: Context,
            route: Routes,
            data: RouterData? = null
        ) = Intent(context, AccessManagerActivity::class.java).apply {
            putExtra(ARG_ROUTE, route)
            putExtra(ARG_DATA, data)
        }
    }
}
