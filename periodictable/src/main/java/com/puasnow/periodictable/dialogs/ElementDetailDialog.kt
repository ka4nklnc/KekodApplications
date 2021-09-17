package com.puasnow.periodictable.dialogs

import android.animation.Animator
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.puasnow.periodictable.R
import com.puasnow.periodictable.adapters.PeriodicLinearAdapter
import com.puasnow.periodictable.models.Element
import kotlinx.coroutines.*
import java.text.DecimalFormat

class ElementDetailDialog(mContext: Context,val item: Element) {
    private var dialog: Dialog = Dialog(mContext, R.style.full_screen_dialog)

    private var viewPager: ViewPager
    private var tv_number: TextView
    private var tv_symbol: TextView
    private var tv_name: TextView
    private var tv_atomicweight: TextView
    private var tv_atomicweight_value: TextView
    private var tv_electronconfig: TextView
    private var tv_electronconfig_value: TextView
    private var iv_electronpic: ImageView

    private var selectedItem :Element
    private var changeCounter = 0


    init {
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.dialog_elementdetail)

        viewPager = dialog.findViewById(R.id.viewPager)
        tv_number = dialog.findViewById(R.id.tv_number)
        tv_symbol = dialog.findViewById(R.id.tv_symbol)
        tv_name = dialog.findViewById(R.id.tv_name)
        tv_atomicweight = dialog.findViewById(R.id.tv_atomicweight)
        tv_atomicweight_value = dialog.findViewById(R.id.tv_atomicweight_value)
        tv_electronconfig = dialog.findViewById(R.id.tv_electronconfig)
        tv_electronconfig_value = dialog.findViewById(R.id.tv_electronconfig_value)
        iv_electronpic = dialog.findViewById(R.id.iv_elementpic)
        selectedItem = item

        setAdapter()
        dialog.show()

        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        tv_symbol.text= selectedItem.symbol
        fadeOutIn()
    }



    private fun setAdapter(){
        val adapter = PeriodicLinearAdapter(viewPager) {
            changeCounter++
            fadeOutIn()
            animate(tv_symbol){
                tv_symbol.text = selectedItem.symbol
            }
            selectedItem = it
        }
        viewPager.adapter = adapter
        adapter.setSelectedItem(item)
    }

    private fun fadeOutIn(){
        animate(tv_number){
            tv_number.text = selectedItem.number
        }
        animate(tv_name){
            tv_name.text = selectedItem.name
        }
        animate(tv_atomicweight){}
        animate(tv_atomicweight_value){
            tv_atomicweight_value.text = selectedItem.atomic_mass
        }
        animate(tv_electronconfig){}
        animate(tv_electronconfig_value){
            tv_electronconfig_value.text = selectedItem.electron_configuration
        }
        animate(iv_electronpic){
                GlobalScope.launch(Dispatchers.Main) {
                    delay(300)
                    val drawable = when{
                        changeCounter %4 == 0 -> R.drawable.img_carbon;
                        changeCounter % 3 == 0 -> R.drawable.img_cerium;
                        changeCounter % 2 == 0 -> R.drawable.img_sodium;
                        else -> R.drawable.img_titanium
                    }
                    iv_electronpic.setImageResource(drawable)
                }
            }



        GlobalScope.launch(Dispatchers.Main){
            delay(300)
            counterAnimation()
        }

    }

    private fun animate(view: View,callback:()->Unit){
        view.animate().setDuration(100).alpha(0f).setListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                callback.invoke()
                view.animate().setDuration(500).alpha(1f)
            }

            override fun onAnimationCancel(animation: Animator?) {
                callback.invoke()
                view.animate().setDuration(500).alpha(1f)
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }

        })
    }

    private fun counterAnimation(){
        val formatType =DecimalFormat("#.000")
        val isInteger = selectedItem.atomic_mass?.indexOf(".")==-1
        var counter = when(isInteger){
            true -> selectedItem.atomic_mass?.toDouble()?.minus(150)
            else -> selectedItem.atomic_mass?.toDouble()?.minus(0.0150)
        }
        GlobalScope.launch(Dispatchers.IO){
            repeat(150){
                delay(5)
                GlobalScope.launch(Dispatchers.Main) {
                    tv_atomicweight_value.text = if(counter != null){
                        counter = if(isInteger){

                            counter!! + 1
                        }else {

                            counter!! + 0.0001
                        }

                        if(isInteger){
                            counter!!.toInt().toString()
                        }
                        else formatType.format(counter!!)

                    } else "0"
                }
            }
        }

    }
}