package com.puasnow.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.puasnow.news.fragments.MyListFragment
import com.puasnow.news.fragments.NewsDetail2Fragment
import com.puasnow.news.fragments.NewsDetailFragment

class MainActivity : AppCompatActivity() {
    var isBack = false
    var counter = 0;
    val listFragment = MyListFragment {
        isBack = true
        counter++;
        if(counter%2 == 0){
            supportFragmentManager.beginTransaction().replace(R.id.container, NewsDetailFragment(it)).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.container, NewsDetail2Fragment(it)).commit()
        }

    };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, listFragment).commit()

    }

    override fun onBackPressed() {
        if(isBack){
            supportFragmentManager.beginTransaction().replace(R.id.container, listFragment).commit()
        } else super.onBackPressed()

    }

}