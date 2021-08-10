package com.example.tvbottomnavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.fragment_third.view.*

class ThirdFragment : Fragment() {

    private lateinit var adapter: RecyclerAdapter<Barber>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_third, container, false)
        initAdapter()
        v.recycler.adapter = adapter
        v.recycler2.adapter = adapter
        v.recycler3.adapter = adapter
        return v
    }
    private fun initAdapter() {
        adapter = RecyclerAdapter()
        adapter.datas = arrayListOf(
            Barber("سونی 1", "1","https://sonyland.co/storage/categories/August2021/gdSEdgAi02flIw1pzz.png"),
            Barber("سونی 2", "2","https://sonyland.co/storage/products/July2021/tv_banner.png"),
            Barber("سونی 3", "3","https://sonyland.co/storage/products/July2021/tv2.webp") ,
            Barber("سونی 4", "4","https://sonyland.co/storage/products/July2021/tv1.webp") ,
            Barber("سونی 5", "5","https://sonyland.co/storage/products/July2021/s2.webp") ,
            Barber("سونی 6", "6","https://sonyland.co/storage/products/August2021/5pANPnXvx0TlHIXUXd.webp") ,
            Barber("سونی 7", "7","https://sonyland.co/storage/products/July2021/tv_banner.png") ,
            Barber("سونی 8", "8","https://sonyland.co/storage/categories/August2021/gdSEdgAi02flIw1pzz.png") ,
            Barber("سونی 9", "9","https://sonyland.co/storage/products/July2021/tv_banner.png"),
            Barber("سونی 10", "10","https://sonyland.co/storage/products/July2021/tv2.webp") ,
            Barber("سونی 11", "11","https://sonyland.co/storage/products/July2021/tv1.webp") ,
            Barber("سونی 12", "12","https://sonyland.co/storage/categories/August2021/gdSEdgAi02flIw1pzz.png") ,
            Barber("سونی 13", "13","https://sonyland.co/storage/products/July2021/tv2.webp") ,
            Barber("سونی 14", "14","https://sonyland.co/storage/products/July2021/tv_banner.png") ,
            Barber("سونی 15", "15","https://sonyland.co/storage/categories/August2021/gdSEdgAi02flIw1pzz.png")
        )
        adapter.onClickHandler = object : OnClickHandler<Barber> {
            override fun onClickItem(element: Barber) {}
            override fun onClick(view: View) {}
            override fun onClickView(view: View, element: Barber) {
                val directions =FirstFragmentDirections.actionFirstFragmentToDetailFragment(element)
                findNavController().navigate(directions)
            }
        }
    }

}