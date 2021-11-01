package com.example.toolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(Toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //viewpager
        val pager = findViewById<ViewPager2>(R.id.pager)
        val listFragment = listOf<Fragment>(FirstFragment(), SecondFragment())
        val pagerAdapter = PagerAdapter(this, listFragment)
       // pager.adapter = pagerAdapter

    }

    class PagerAdapter(val activity: AppCompatActivity, val listFragment: List<Fragment>): FragmentStateAdapter(activity){
        override fun getItemCount(): Int = listFragment.size

        override fun createFragment(position: Int): Fragment = listFragment.get(position)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuName -> Toast.makeText(this, "Menu Utama", Toast.LENGTH_SHORT)
            R.id.menuSetting -> Toast.makeText(this, "Konfigurasi", Toast.LENGTH_SHORT)
        }

        return super.onOptionsItemSelected(item)
    }


}