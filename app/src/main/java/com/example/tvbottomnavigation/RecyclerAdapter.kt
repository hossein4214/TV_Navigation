package com.example.tvbottomnavigation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvbottomnavigation.databinding.RowPersonBinding

class RecyclerAdapter<T>(
):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var isGrid = false
    var onClickHandler: OnClickHandler<T> ?= null
    var datas: List<T> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }
    private lateinit var layoutInflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            R.layout.row_person ->
                BarberViewHolder(
                    RowPersonBinding.inflate(layoutInflater, parent, false)
                )
            else -> throw IllegalStateException("the type is invalid!!")
        }
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BarberViewHolder ->
                holder.bind(datas[position] as Barber , onClickHandler = onClickHandler)

        }
    }

    override fun getItemViewType(position: Int): Int =
            when(datas[0]){
                is Barber -> R.layout.row_person
                else -> throw IllegalStateException("the type is invalid!")
            }
}