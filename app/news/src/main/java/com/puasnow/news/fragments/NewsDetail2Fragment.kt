package com.puasnow.news.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.puasnow.news.R
import com.puasnow.news.mdoels.NewsModel

class NewsDetail2Fragment(private val model: NewsModel): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return   inflater.inflate(R.layout.fragment_detail2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.image).setImageResource(model.img)
        view.findViewById<TextView>(R.id.title).text = model.title
        view.findViewById<ImageView>(R.id.imagesource).setImageResource(model.sourceimg)
        view.findViewById<TextView>(R.id.time).text = model.timeago
        view.findViewById<TextView>(R.id.text).text = model.text
        view.findViewById<ImageView>(R.id.backButton).setOnClickListener {
            requireActivity().onBackPressed()
        }

    }
}