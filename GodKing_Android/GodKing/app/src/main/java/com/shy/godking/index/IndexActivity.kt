package com.shy.godking.index

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.shy.godking.*

class IndexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        findViewById<ViewPager2>(R.id.viewPager2).adapter = object : FragmentStateAdapter(this){
            override fun getItemCount() = 4

            override fun createFragment(position: Int): Fragment {
                return when(position){
                    0-> TableFragment()
                    1-> NotesFragment()
                    2-> WeatherFragment()
                    else -> MyFragment()
                }
            }
        }
        TabLayoutMediator(findViewById(R.id.tab),findViewById(R.id.viewPager2)){ tab, position->
            when(position){
                0->tab.setIcon(R.mipmap.godking_index)
                1->tab.setIcon(R.mipmap.godking_notes)
                2->tab.setIcon(R.mipmap.godking_weather)
                else->tab.setIcon(R.mipmap.godking_my)
            }
        }.attach()
    }
}
