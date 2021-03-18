package com.example.tvbottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {
    private lateinit var adapter: RecyclerAdapter<Barber>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_first, container, false)
        initAdapter()
        v.recycler.adapter = adapter
        return v
    }

    private fun initAdapter() {
        adapter = RecyclerAdapter()
        adapter.datas = arrayListOf(
            Barber("name", "1"),
            Barber("name2", "2"),
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3") ,
            Barber("name3", "3")
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