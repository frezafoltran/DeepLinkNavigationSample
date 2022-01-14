package com.foltran.feature_sample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.foltran.feature_sample.navigation.FeatureRouterData
import com.foltran.navigation_deeplink.Routable

import android.widget.ImageView
import com.foltran.feature_sample.R
import com.squareup.picasso.Picasso


class FeatureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        val dataFromIntent = intent.getParcelableExtra<FeatureRouterData>(Routable.ROUTE_INTENT_DATA)


        findViewById<TextView>(R.id.textViewTag).apply {

            text = if (beatles.contains(dataFromIntent?.beatle)) {
                dataFromIntent?.beatle
            } else {
                context.getString(R.string.beatle_not_found)
            }
        }

        findViewById<ImageView>(R.id.imageView).apply {
            Picasso.get().load(beatles[dataFromIntent?.beatle]).into(this)
        }
    }

    companion object {

        val beatles = HashMap<String, String>().apply{
            put("john", "https://www.beatlesbible.com/wp/media/john-lennon_012-522x580.jpg")
            put("paul", "https://www.beatlesbible.com/wp/media/paul-mccartney_001.jpg")
            put("george", "https://www.beatlesbible.com/wp/media/george-harrison_018-390x580.jpg")
            put("ringo", "https://www.beatlesbible.com/wp/media/ringo-starr_008.jpg")
        }
    }
}