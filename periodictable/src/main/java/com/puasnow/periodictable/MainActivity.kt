package com.puasnow.periodictable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puasnow.periodictable.models.Elements

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Elements.set(this)
    }
}