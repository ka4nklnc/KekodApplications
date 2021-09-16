package com.puasnow.periodictable.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.viewpager.widget.ViewPager
import com.puasnow.periodictable.R
import com.puasnow.periodictable.models.Element
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ElementDetailDialog(mContext: Context,val item: Element) {
    private var dialog: Dialog = Dialog(mContext, R.style.full_screen_dialog)

    private var viewPager: ViewPager
    private var tv_number: TextView
    private var tv_symbol: TextView
    private var tv_name: TextView
    private var tv_atomicweight: TextView
    private var tv_electronconfig: TextView
    private var iv_electronpic: ImageView


    init {
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.dialog_elementdetail)

        viewPager = dialog.findViewById(R.id.viewPager)
        tv_number = dialog.findViewById(R.id.tv_number)
        tv_symbol = dialog.findViewById(R.id.tv_symbol)
        tv_name = dialog.findViewById(R.id.tv_name)
        tv_atomicweight = dialog.findViewById(R.id.tv_atomicweight_value)
        tv_electronconfig = dialog.findViewById(R.id.tv_electronconfig_value)
        iv_electronpic = dialog.findViewById(R.id.iv_elementpic)
tv_name.text = item.name
        dialog.show()

        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        counterAnimation()
    }

    private fun counterAnimation(){
        val isInteger = item.atomic_mass?.indexOf(".")==-1
        var counter = when(isInteger){
            true -> item.atomic_mass?.toDouble()?.minus(120)
            else -> item.atomic_mass?.toDouble()?.minus(0.0120)
        }
        GlobalScope.launch(Dispatchers.Main){
            repeat(120){
                delay(10)
                if(counter != null){
                    counter = if(isInteger){
                        counter!! + 1
                    }else {
                        counter!! + 0.01
                    }
                    tv_atomicweight.text = if(isInteger){
                      counter!!.toInt().toString()
                    }
                    else counter!!.toString().format()

                }else
                    tv_atomicweight.text = "0"

            }
        }

    }
}