package com.puasnow.news.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.puasnow.news.R

class ProfileLayout(context: Context, attrs: AttributeSet?): LinearLayout(context,attrs) {

    private val view: View = inflate(context, R.layout.layout_profile,this)

    init {

    }
}