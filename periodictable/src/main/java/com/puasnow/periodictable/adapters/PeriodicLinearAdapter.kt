package com.puasnow.periodictable.adapters

import android.graphics.Color
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.puasnow.periodictable.databinding.ItemPeriodictableBinding
import com.puasnow.periodictable.models.Element
import com.puasnow.periodictable.models.Elements

class PeriodicLinearAdapter(val viewPager: ViewPager,val onClick: (selectedItem: Element) -> Unit): PagerAdapter() {



    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mBinding = ItemPeriodictableBinding.inflate(LayoutInflater.from(container.context),container,false)

        val model = getItem(position)
        PeriodicTableViewHolder(mBinding).bind(model).setOnSelected(::selectedItem)
        container.addView(mBinding.root)

        return mBinding.root
    }

    private fun selectedItem(item:Element) {
        onClick.invoke(item)
        setSelectedItem(item,true)

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView((`object` as View))
    }

    override fun getCount() = Int.MAX_VALUE

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    fun setSelectedItem(item: Element, animation:Boolean=true):Int{
        Elements.elements.forEach {
            it.isSelected = item.number == it.number
        }
        this.notifyDataSetChanged()
       val index =  Elements.elements.indexOf(item)+(Elements.elements.size*2)
        viewPager.setCurrentItem(index - 1, animation)
        return index
    }


    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun getPageWidth(position: Int)= 0.33f

    private fun getItem(position: Int): Element {
        return Elements.elements[position % Elements.elements.size]
    }

    inner class PeriodicTableViewHolder(val mBinding:ItemPeriodictableBinding):RecyclerView.ViewHolder(mBinding.root) {

        var onClick: ((Element) -> Unit) ? =null
        fun bind(item:Element): PeriodicTableViewHolder {
            mBinding.model = item
            setColor(item.isSelected,item.fontColor?:"",item.backgroundColor?:"")

            mBinding.layout.setOnClickListener {
                onClick?.invoke(item)
            }

            return this
        }

        private fun setColor(isItemSelected:Boolean, fontColor:String,backgroundColor:String){
            try{

                val color = if(isItemSelected) Color.BLACK else  Color.parseColor(fontColor)
                mBinding.textView.setTextColor(color)
                mBinding.textView1.setTextColor(color)
                mBinding.textView2.setTextColor(color)
                mBinding.textView3.setTextColor(color)

                val backgroundColor = if(isItemSelected) Color.WHITE else Color.parseColor(backgroundColor)
                mBinding.layout.setBackgroundColor(backgroundColor)
            }catch (e:Exception){}
        }

        fun setOnSelected(onClick:(selectedItem:Element)->Unit): PeriodicTableViewHolder {
            this.onClick = onClick
            return this
        }
    }



}