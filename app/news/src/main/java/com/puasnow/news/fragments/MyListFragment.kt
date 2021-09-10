package com.puasnow.news.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.puasnow.news.R
import com.puasnow.news.mdoels.NewsModel
import com.puasnow.news.mdoels.getFakeData
import com.puasnow.news.views.NewsLayout

class MyListFragment(val clickedItem : (NewsModel) -> Unit) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return   inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listLayout= view.findViewById<LinearLayout>(R.id.listLayout)


        for (item in getFakeData()){
            val news = NewsLayout(view.context,item,null)
            news.setOnClickListener {
                clickedItem.invoke(item);
            }
            listLayout.addView(news)
        }

    }

}