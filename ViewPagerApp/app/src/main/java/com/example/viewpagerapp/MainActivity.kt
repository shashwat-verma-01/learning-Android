package com.example.viewpagerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager2 : ViewPager2
    lateinit var myAdapter : MyPagerAdapter
    lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        1 - Inititalize the ViewPager
        viewPager2 = findViewById(R.id.viewPager2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

//        2 - Add Fragments to the list in the adapter class
        myAdapter = MyPagerAdapter(supportFragmentManager, lifecycle)
        myAdapter.addFragmentaToList(FragmentOne())
        myAdapter.addFragmentaToList(FragmentTwo())
        myAdapter.addFragmentaToList(FragmentThree())

//        3 - Connecting the adapter with ViewPager2
        viewPager2.adapter = myAdapter

        tabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(
            tabLayout,
            viewPager2
        ){
            tab, position -> tab.text = "Tab ${position + 1}"
        }.attach()
    }
}