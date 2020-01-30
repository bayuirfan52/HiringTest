package com.bayuirfan.hiring.pinterestimage.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import com.bayuirfan.hiring.pinterestimage.R
import com.bayuirfan.hiring.pinterestimage.adapter.TabAdapter
import com.bayuirfan.hiring.pinterestimage.features.pins.PinsFragment
import com.bayuirfan.hiring.pinterestimage.features.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: FragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TabAdapter(supportFragmentManager,
            mapOf(
                getString(R.string.pins) to PinsFragment(),
                getString(R.string.user) to UserFragment()
            ))
        vp_main.adapter = adapter
        tab_main.setupWithViewPager(vp_main)
    }
}
