package com.puasnow.periodictable.adapters.viewholders

import android.animation.Animator
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.puasnow.periodictable.databinding.ItemPeriodictableBinding
import com.puasnow.periodictable.dialogs.ElementDetailDialog
import com.puasnow.periodictable.models.Element

class PeriodicGridViewHolder(private val mBinding:ItemPeriodictableBinding) : RecyclerView.ViewHolder(mBinding.root){
    fun bind(item: Element) {
        mBinding.model = item
        mBinding.textView2.text = item.number
        mBinding.textView3.text = item.symbol
        mBinding.textView.text = item.name

        setColor(item.fontColor?:"#00FFFFFF", item.backgroundColor?:"#00FFFFFF")

        mBinding.layout.setOnClickListener {
            zoomEffect(item)


        }
    }

    private fun setColor(fontColor:String,backgroundColor:String){
        try{
                val color = Color.parseColor(fontColor)
                mBinding.textView.setTextColor(color)
                mBinding.textView1.setTextColor(color)
                mBinding.textView2.setTextColor(color)
                mBinding.textView3.setTextColor(color)


                mBinding.layout.setBackgroundColor(Color.parseColor(backgroundColor))
        }catch (e:Exception){}
    }

    private fun zoomEffect(item:Element){
        val backgroundColors = arrayOf(ColorDrawable(Color.parseColor(item.backgroundColor)),
            ColorDrawable(Color.WHITE)
        )
        val backgroundDrawable = TransitionDrawable(backgroundColors)
        mBinding.layout.background = backgroundDrawable

        mBinding.textView.setTextColor(Color.BLACK)
        mBinding.textView1.setTextColor(Color.BLACK)
        mBinding.textView2.setTextColor(Color.BLACK)


        mBinding.layout.animate().scaleX(1.15f).scaleY(1.15f).z(15f) .setDuration(150).setListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
                backgroundDrawable.startTransition(150)
            }

            override fun onAnimationEnd(animation: Animator?) {
                ElementDetailDialog(mBinding.root.context,item)
                zoomOutEffect(item)
                backgroundDrawable.reverseTransition(500)

            }

            override fun onAnimationCancel(animation: Animator?) {
                //backgroundDrawable.reverseTransition(300)
                //fontDrawable.reverseTransition(300)
                zoomOutEffect(item)
            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        })
    }

    private fun zoomOutEffect(item:Element){

        mBinding.textView.setTextColor(Color.parseColor(item.fontColor))
        mBinding.textView1.setTextColor(Color.parseColor(item.fontColor))
        mBinding.textView2.setTextColor(Color.parseColor(item.fontColor))
        mBinding.layout.animate().scaleX(1f).scaleY(1f).translationZ(1f) .setDuration(500).setListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        })
    }


}