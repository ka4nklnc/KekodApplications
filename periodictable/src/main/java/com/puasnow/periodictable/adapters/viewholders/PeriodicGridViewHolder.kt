package com.puasnow.periodictable.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.puasnow.periodictable.databinding.ItemPeriodictableBinding
import com.puasnow.periodictable.models.Element
import com.puasnow.periodictable.models.PeriodicTableModel

class PeriodicGridViewHolder(private val mBinding:ItemPeriodictableBinding) : RecyclerView.ViewHolder(mBinding.root){
    fun bind(item: Element) {
        mBinding.model = item
    }
}