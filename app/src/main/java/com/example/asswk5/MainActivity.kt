package com.example.asswk5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout  //responsible for the tabs
    private lateinit var viewPager: ViewPager2 //responsible for the scrolling action
    private lateinit var toolbar:androidx.appcompat.widget.Toolbar//responsible for the swiping action

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        tabLayout=  findViewById(R.id.tabs)
        viewPager = findViewById(R.id.view_pager)

        viewPager.adapter = MainPageAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            when(position){
                0-> tab.text="Books"
                1-> tab.text ="Videos"
                else-> tab.text ="Books"
            }
        }.attach()
        viewPager.currentItem=0
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

}