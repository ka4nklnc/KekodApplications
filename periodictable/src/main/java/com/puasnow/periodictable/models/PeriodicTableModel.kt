package com.puasnow.periodictable.models

import android.content.Context
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

class Elements {
    companion object {
        private var _elements = ArrayList<Element>()
        val elements :List<Element> get() = _elements

        fun set(context: Context){
            val raw: InputStream = context.assets.open("periodictable.json")

            val file: Reader = BufferedReader(InputStreamReader(raw, "UTF8"))
            val model = Gson().fromJson(file,PeriodicModel::class.java)
            _elements.clear()
            _elements.addAll(model.elements)
        }

    }
}