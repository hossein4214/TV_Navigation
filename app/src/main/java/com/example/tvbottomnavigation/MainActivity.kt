package com.example.tvbottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.replace
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.tvbottomnavigation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerAdapter<Barber>
    private lateinit var binding: ActivityMainBinding
    private var isItemFocused = true
    private var isExpanded = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val drawer: NavigationView = findViewById(R.id.navigation_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val nav = Navigation.findNavController(this, R.id.fragment)
        //NavigationUI.setupWithNavController(drawer,navController)
        //initAdapter()
        //fra_fi_rv.adapter = adapter
        /*drawer.setNavigationItemSelectedListener { item ->
            expand()
            supportFragmentManager.popBackStack()
            when (item.itemId) {
                R.id.firstFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, FirstFragment()).commit()
                }
                R.id.secondFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, SecondFragment()).commit()
                }
                R.id.thirdFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, ThirdFragment()).commit()
                }
            }
            return@setNavigationItemSelectedListener true
        }*/
        binding.menuFirst.apply {
            setOnClickListener {
                /*if (isExpanded) {
                    collapse()
                    isExpanded = !isExpanded
                }*/

                nav.navigate(R.id.action_global_leftFragment)
                nav.navigate(R.id.action_leftFragment_to_firstFragment)
                //binding.guideline1.requestFocus()
            }
            setOnFocusChangeListener { v, hasFocus ->
                focusCheck()
                if (hasFocus) {
                    if (!isExpanded) {
                        expand()
                        isExpanded = !isExpanded
                    }
                    Log.e("Log", "Button1 Focus Changed $hasFocus")
                }
            }
        }
        binding.menuSecond.apply {
            setOnClickListener {
                /*if (isExpanded) {
                    collapse()
                    isExpanded = !isExpanded
                }*/
                nav.navigate(R.id.action_global_leftFragment)
                nav.navigate(R.id.action_leftFragment_to_secondFragment)
                //binding.guideline1.requestFocus()
            }
            setOnFocusChangeListener { v, hasFocus ->
                focusCheck()

                if (hasFocus) {
                    if (!isExpanded) {
                        expand()
                        isExpanded = !isExpanded
                    }
                    Log.e("Log", "Button2 Focus Changed $hasFocus")
                }
            }
        }
        binding.menuThird.apply {
            setOnClickListener {
                /*if (isExpanded) {
                    collapse()
                    isExpanded = !isExpanded
                }*/
                nav.navigate(R.id.action_global_leftFragment)
                nav.navigate(R.id.action_leftFragment_to_thirdFragment)
                //binding.guideline1.requestFocus()
            }
            setOnFocusChangeListener { v, hasFocus ->
                focusCheck()

                if (hasFocus) {
                    if (!isExpanded) {
                        expand()
                        isExpanded = !isExpanded
                    }
                    Log.e("Log", "Button3 Focus Changed $hasFocus")
                }
            }
        }
    }


    private fun initAdapter() {
        adapter = RecyclerAdapter()
        adapter.datas = arrayListOf(
            Barber("name", "1"),
            Barber("name2", "2"), Barber
                ("name3", "3")
        )
        adapter.notifyDataSetChanged()
        adapter.onClickHandler = object : OnClickHandler<Barber> {
            override fun onClickItem(element: Barber) {}
            override fun onClick(view: View) {}
            override fun onClickView(view: View, element: Barber) {
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun collapse() {
        val const = findViewById<ConstraintLayout>(R.id.constraint)
        val constSet = ConstraintSet()
        constSet.apply {
            clone(const)
            connect(R.id.menu, ConstraintSet.END, R.id.guideline2, ConstraintSet.END)
            applyTo(const)
        }
    }

    private fun expand() {
        val const = findViewById<ConstraintLayout>(R.id.constraint)
        val constSet = ConstraintSet()
        constSet.apply {
            clone(const)
            connect(R.id.menu, ConstraintSet.END, R.id.guideline1, ConstraintSet.END)
            applyTo(const)
        }
    }

    private fun focusCheck(){
        if(!binding.menuFirst.isFocused && !binding.menuThird.isFocused && !binding.menuSecond.isFocused){
            collapse()
            isExpanded = !isExpanded
        }
    }

}