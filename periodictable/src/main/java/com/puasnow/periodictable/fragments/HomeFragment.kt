package com.puasnow.periodictable.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.puasnow.periodictable.adapters.GridPeriodicTableAdapter
import com.puasnow.periodictable.databinding.FragmentHomeBinding
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
            val list = ArrayList<PeriodicTableModel>()
            for(item in 1..20){
                list.add(PeriodicTableModel("0","42","24","Brom","Br"))
                list.add(PeriodicTableModel("0","42","24","Brom","Br"))
                list.add(PeriodicTableModel("0","42","24","Brom","Br"))
                list.add(PeriodicTableModel("0","42","24","Brom","Br"))
                list.add(PeriodicTableModel("0","","","",""))
            }
            val raw: InputStream = requireContext().assets.open("periodictable.json")

            val file: Reader = BufferedReader(InputStreamReader(raw, "UTF8"))
            val model = Gson().fromJson(file,PeriodicModel::class.java)

            mAdapter.submitList(model.elements)
            recyclerView.adapter = mAdapter

        }
    }
}