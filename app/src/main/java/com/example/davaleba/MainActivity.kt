package com.example.davaleba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.davaleba.adapters.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var  viewPager2: ViewPager2
    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)

        viewPager2 = findViewById(R.id.viewPager)
        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)
        viewPager2.adapter = viewPagerFragmentAdapter
        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            tab.text = "tab ${position + 1}"
        }.attach()
    }
}