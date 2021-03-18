package com.example.tvbottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tvbottomnavigation.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_first.view.*


class DetailFragment : Fragment() {

    private lateinit var binding:FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailBinding.inflate(inflater, container, false)
        val barber = DetailFragmentArgs.fromBundle(requireArguments()).barbers
        binding.barber = barber
        return binding.root
    }




}