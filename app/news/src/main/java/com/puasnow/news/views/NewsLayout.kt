package com.puasnow.news.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.puasnow.news.R
import com.puasnow.news.mdoels.NewsModel

class NewsLayout(context: Context, model: NewsModel, attrs:AttributeSet?=null):LinearLayout(context,attrs) {
    private val view: View = inflate(context, R.layout.layout_news,this)

    init {
        view.findViewById<ImageView>(R.id.image).setImageResource(model.img)
        view.findViewById<ImageView>(R.id.imagesource).setImageResource(model.sourceimg)
        view.findViewById<TextView>(R.id.sourceName).text = model.sourcename
        view.findViewById<TextView>(R.id.title).text = model.text
        view.findViewById<TextView>(R.id.time).text = model.timeago
    }
}