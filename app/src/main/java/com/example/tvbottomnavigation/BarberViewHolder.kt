package com.example.tvbottomnavigation

import android.util.Log
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.example.tvbottomnavigation.databinding.RowPersonBinding

class BarberViewHolder(
    private val itemBinding: RowPersonBinding
): RecyclerView.ViewHolder(itemBinding.root){
    fun <T> bind(item: Barber, onClickHandler: OnClickHandler<T>?){
        itemBinding.barber = item
        onClickHandler?.let{
            itemBinding.onClickHandler = onClickHandler
        }
        /*itemBinding.root.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                itemBinding.root.scaleX = 1.1F
                itemBinding.root.scaleY = 1.1F
            }else{
                itemBinding.root.scaleY = 1F
                itemBinding.root.scaleX = 1F
            }
        }*/
    }
}