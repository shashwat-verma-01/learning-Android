package com.example.viewpagerapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fm : FragmentManager, lc : Lifecycle)
    : FragmentStateAdapter(fm, lc) {

    var fragmentList : ArrayList<Fragment> = ArrayList()

    fun addFragmentaToList(fragment: Fragment){
        fragmentList.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }
}