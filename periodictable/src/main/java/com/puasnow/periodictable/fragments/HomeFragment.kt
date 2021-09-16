package com.puasnow.periodictable.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.puasnow.periodictable.adapters.GridPeriodicTableAdapter
import com.puasnow.periodictable.databinding.FragmentHomeBinding
import com.puasnow.periodictable.models.Element
import com.puasnow.periodictable.models.PeriodicModel
import com.puasnow.periodictable.models.PeriodicTableModel
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

class HomeFragment: Fragment() {
    lateinit var mBinding:FragmentHomeBinding

    private val mAdapter: GridPeriodicTableAdapter by lazy {
        GridPeriodicTableAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentHomeBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(mBinding){

            val raw: InputStream = requireContext().assets.open("periodictable.json")

            val file: Reader = BufferedReader(InputStreamReader(raw, "UTF8"))
            val model = Gson().fromJson(file,PeriodicModel::class.java)


            val list = ArrayList<Element>()
            repeat(18) { x ->
                repeat(11) { y ->
                    val columnNumber = when {
                        y == 0 && x == 0 -> 1
                        y == 1 && x == 1 -> 2
                        y == 3 && x == 2 -> 3
                        y == 3 && x == 3 -> 4
                        y == 3 && x == 4 -> 5
                        y == 3 && x == 5 -> 6
                        y == 3 && x == 6 -> 7
                        y == 3 && x == 7 -> 8
                        y == 3 && x == 8 -> 9
                        y == 3 && x == 9 -> 10
                        y == 3 && x == 10 -> 11
                        y == 3 && x == 11 -> 12
                        y == 1 && x == 12 -> 13
                        y == 1 && x == 13 -> 14
                        y == 1 && x == 14 -> 15
                        y == 1 && x == 15 -> 16
                        y == 1 && x == 16 -> 17
                        y == 0 && x == 17 -> 18
                        else -> null
                    }

                    val atomicNumber = when {
                        y == 6 && x == 2 -> "57-71"
                        y == 7 && x == 2 -> "89-103"
                        else -> null
                    }

                    val fontColor = when {
                        x == 0 && y in 0..7 -> "#9F727F"

                        x == 1 && y in 1..7 -> "#9A847E"

                        x in 2..11 && y in 3..8 -> "#72829F"

                        x in 12.. 13 && y == 2 -> "#5CA5C1"
                        x == 13 && y in 2..3 -> "#5CA5C1"
                        x == 14 && y in 3..4 -> "#5CA5C1"
                        x == 15 && y in 4..5 -> "#5CA5C1"

                        x == 12 && y in  3..8 -> "#5FB8A0"
                        x == 13 && y in  4..8 -> "#5FB8A0"
                        x == 14 && y in  5..8 -> "#5FB8A0"
                        x == 15 && y in  6..8 -> "#5FB8A0"

                        x == 14 && y in  2..3 -> "#7993C7"
                        x == 15 && y in  2..4 -> "#7993C7"

                        x == 16 && y in  2..8 -> "#8280C1"

                        x == 17 && y in  1..8 -> "#9A7EC7"

                        x in 0..17 && y == 9 -> "#878B90"
                        x in 0..17 && y == 10 -> "#93777D"
                        else -> ""
                    }

                    val backgroundColor = when {
                        x == 0 && y in 0..7 -> "#332429"

                        x == 1 && y in 1..7 -> "#342C2A"

                        x in 2..11 && y in 3..8 -> "#272B34"

                        x in 12.. 13 && y == 2 -> "#253D49"
                        x == 13 && y in 2..3 -> "#253D49"
                        x == 14 && y in 3..4 -> "#253D49"
                        x == 15 && y in 4..5 -> "#253D49"

                        x == 12 && y in  3..8 -> "#203D35"
                        x == 13 && y in  4..8 -> "#203D35"
                        x == 14 && y in  5..8 -> "#203D35"
                        x == 15 && y in  6..8 -> "#203D35"

                        x == 14 && y in  2..3 -> "#2A3247"
                        x == 15 && y in  2..4 -> "#2A3247"

                        x == 16 && y in  2..8 -> "#2B2B45"

                        x == 17 && y in  1..8 -> "#322944"

                        x in 0..17 && y == 9 -> "#2C2D2F"
                        x in 0..17 && y == 10 -> "#2F2929"

                        else -> ""
                    }

                    if(columnNumber == null && atomicNumber == null ){
                        if(y == 8){
                            list.add(Element())
                        }
                        else {
                            val yPos = if (y > 10) y - 2 else y
                            val element =
                                model.elements.firstOrNull { lamb -> lamb.xpos == x + 1 && lamb.ypos == yPos }
                            if (element == null)
                                list.add(Element())
                            else {
                                element.fontColor = fontColor
                                element.backgroundColor = backgroundColor
                                list.add(element)
                            }
                        }

                    }else if(columnNumber != null) {
                        list.add(Element(name = columnNumber.toString(), fontColor = "#FFFFFF"))
                        Log.i("HomeFragmnet", "columnNumber $columnNumber")
                    }
                    else if(atomicNumber != null) {
                        list.add(Element(number = atomicNumber.toString(), fontColor = "#FFFFFF"))
                        Log.i("HomeFragmnet", "atomicNumber $atomicNumber")
                    }








                }
            }


            mAdapter.submitList(list)
            recyclerView.adapter = mAdapter

        }
    }

}