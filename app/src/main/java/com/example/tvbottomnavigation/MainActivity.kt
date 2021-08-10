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
    private var lastItemFocused = -1
    private var isExpanded = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.isExpand = true
        val nav = Navigation.findNavController(this, R.id.fragment)

        binding.acMainDrawerHome.apply {
            setOnClickListener {
                binding.isSelected=0
                lastItemFocused = 0
                nav.navigate(R.id.action_global_leftFragment)
                nav.navigate(R.id.action_leftFragment_to_firstFragment)
            }
            setOnFocusChangeListener { v, hasFocus ->
                focusCheck()
                if (hasFocus) {
                    if (!isExpanded) {
                        expand()
                        isExpanded = true
                    }
                }
            }
        }
        binding.acMainDrawerStore.apply {
            setOnClickListener {
                binding.isSelected=1
                lastItemFocused = 1
                nav.navigate(R.id.action_global_leftFragment)
                nav.navigate(R.id.action_leftFragment_to_secondFragment)
            }
            setOnFocusChangeListener { v, hasFocus ->
                focusCheck()

                if (hasFocus) {
                    if (!isExpanded) {
                        expand()
                        isExpanded = true
                    }
                }
            }
        }
        binding.acMainDrawerContent.apply {
            setOnClickListener {
                binding.isSelected = 2
                lastItemFocused = 2
                nav.navigate(R.id.action_global_leftFragment)
                nav.navigate(R.id.action_leftFragment_to_thirdFragment)
            }
            setOnFocusChangeListener { v, hasFocus ->
                focusCheck()

                if (hasFocus) {
                    if (!isExpanded) {
                        expand()
                        isExpanded = true
                    }
                }
            }
        }
        binding.acMainDrawerAccount.apply {
            setOnClickListener {
                binding.isSelected = 3
                lastItemFocused = 3
                nav.navigate(R.id.action_global_leftFragment)
                nav.navigate(R.id.action_leftFragment_to_thirdFragment)
            }
            setOnFocusChangeListener { v, hasFocus ->
                focusCheck()

                if (hasFocus) {
                    if (!isExpanded) {
                        expand()
                        isExpanded = true
                    }
                }
            }
        }
        binding.acMainDrawerExit.apply {
            setOnClickListener {
                binding.isSelected = 4
                lastItemFocused = 4
                nav.navigate(R.id.action_global_leftFragment)
                nav.navigate(R.id.action_leftFragment_to_thirdFragment)
            }
            setOnFocusChangeListener { v, hasFocus ->
                focusCheck()

                if (hasFocus) {
                    if (!isExpanded) {
                        expand()
                        isExpanded = true
                    }
                }
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
            connect(R.id.ac_main_drawer, ConstraintSet.START, R.id.guideline2, ConstraintSet.START)
            applyTo(const)
        }
        when{
            binding.acMainDrawerHome.isSelected-> lastItemFocused = 0
            binding.acMainDrawerStore.isSelected-> lastItemFocused = 1
            binding.acMainDrawerContent.isSelected-> lastItemFocused = 2
            binding.acMainDrawerAccount.isSelected-> lastItemFocused = 3
            binding.acMainDrawerExit.isSelected-> lastItemFocused = 4
        }
        Log.e("Hossein","Collapse -> $lastItemFocused")

    }

    private fun expand() {
        val const = findViewById<ConstraintLayout>(R.id.constraint)
        val constSet = ConstraintSet()
        constSet.apply {
            clone(const)
            connect(R.id.ac_main_drawer, ConstraintSet.START, R.id.guideline1, ConstraintSet.START)
            applyTo(const)
        }
        binding.isExpand = true
        when(lastItemFocused){
            0 ->{ binding.acMainDrawerHome.requestFocus()}
            1 ->{ binding.acMainDrawerStore.requestFocus()}
            2 ->{ binding.acMainDrawerContent.requestFocus()}
            3 ->{ binding.acMainDrawerAccount.requestFocus()}
            4 ->{ binding.acMainDrawerExit.requestFocus()}
        }
        Log.e("Hossein","Expand -> $lastItemFocused")
    }

    private fun focusCheck(){
        if(!binding.acMainDrawerHome.isFocused && !binding.acMainDrawerStore.isFocused && !binding.acMainDrawerContent.isFocused && !binding.acMainDrawerAccount.isFocused && !binding.acMainDrawerExit.isFocused){
            collapse()
            isExpanded = false
            binding.isExpand =false
        }
        Log.e("Hossein","Check Focus -> $lastItemFocused")

    }


    override fun onBackPressed() {
        if(!isExpanded){
            expand()
            isExpanded = true
            binding.isExpand = true
        }else{
            super.onBackPressed()
        }
    }

}