package com.apra.innews

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val headingnews : TextView=findViewById(R.id.heading)
        val mainNews : TextView= findViewById(R.id.news)
        val imageNews : ImageView = findViewById(R.id.image_heading)

        val bundle : Bundle? = intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val news = bundle.getString("news")

        headingnews.text =heading
        mainNews.text = news
        imageNews.setImageResource(imageId)
    }
}