package com.puasnow.periodictable.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.puasnow.periodictable.databinding.ItemPeriodictableEmptyBinding
import com.puasnow.periodictable.models.Element

class PeriodicGridEmptyViewHolder(private val mBinding:ItemPeriodictableEmptyBinding):RecyclerView.ViewHolder(mBinding.root) {
    fun bind(item: Element){
        mBinding.model = item
    }
}