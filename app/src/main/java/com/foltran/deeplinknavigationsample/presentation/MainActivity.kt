package com.foltran.deeplinknavigationsample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.foltran.deeplinknavigationsample.R
import com.foltran.deeplinknavigationsample.presentation.AccessManagerActivity.Companion.newIntent
import com.foltran.feature_sample.navigation.FeatureRouterData
import com.foltran.navigation_deeplink.Routes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonJohn).setOnClickListener {
            goToFeatureSample("john")
        }
        findViewById<Button>(R.id.buttonGeorge).setOnClickListener {
            goToFeatureSample("george")
        }
        findViewById<Button>(R.id.buttonPaul).setOnClickListener {
            goToFeatureSample("paul")
        }
        findViewById<Button>(R.id.buttonRingo).setOnClickListener {
            goToFeatureSample("ringo")
        }
    }

    private fun goToFeatureSample(message: String){
        startActivity(newIntent(this, Routes.FeatureSample, FeatureRouterData(message)))
    }

}
