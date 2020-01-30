package com.bayuirfan.hiring.pinterestimage.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(fragmentManager: FragmentManager,
                 map: Map<String, Fragment>) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val fragment = map.values.toList()
    private val title = map.keys.toList()
    override fun getItem(position: Int): Fragment = fragment[position]

    override fun getCount(): Int = fragment.size

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}