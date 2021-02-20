package com.wisnuwahyudi.aplikasikuis.tampilankuis.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wisnuwahyudi.aplikasikuis.R
import com.wisnuwahyudi.aplikasikuis.tampilankuis.fragment.*

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES =
        intArrayOf(R.string.one, R.string.two, R.string.three, R.string.four, R.string.five)

    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> fragment = Soal_One_Fragment()
            1 -> fragment = Soal_Two_Fragment()
            2 -> fragment = Soal_Three_Fragment()
            3 -> fragment = Soal_Four_Fragment()
            4 -> fragment = Soal_Five_Fragment()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return  mContext.resources.getString(TAB_TITLES[position])
    }
}