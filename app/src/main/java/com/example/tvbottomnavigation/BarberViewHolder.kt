package com.example.tvbottomnavigation

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
    }
}