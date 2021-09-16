package com.puasnow.periodictable.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.puasnow.periodictable.adapters.viewholders.PeriodicGridEmptyViewHolder
import com.puasnow.periodictable.adapters.viewholders.PeriodicGridViewHolder
import com.puasnow.periodictable.databinding.ItemPeriodictableBinding
import com.puasnow.periodictable.databinding.ItemPeriodictableEmptyBinding
import com.puasnow.periodictable.models.Element
import com.puasnow.periodictable.models.PeriodicTableModel

class GridPeriodicTableAdapter: ListAdapter<Element,RecyclerView.ViewHolder>(object:DiffUtil.ItemCallback<Element>(){
    override fun areItemsTheSame(oldItem: Element, newItem: Element): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Element, newItem: Element): Boolean {
       return oldItem.name == newItem.name
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        lateinit var viewHolder:RecyclerView.ViewHolder

        when(viewType){
           // 0 -> viewHolder = PeriodicGridEmptyViewHolder(ItemPeriodictableEmptyBinding.inflate(inflater, parent,false))
            1 -> viewHolder = PeriodicGridViewHolder(ItemPeriodictableBinding.inflate(inflater, parent,false))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position).let {
                (holder as PeriodicGridViewHolder) .bind(it)

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).isEmptySlot) 0 else 1
    }

    override fun getItem(position: Int): Element {
        return  super.getItem(position)
    }
}