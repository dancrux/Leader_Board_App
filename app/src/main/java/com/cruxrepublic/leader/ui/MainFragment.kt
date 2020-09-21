package com.cruxrepublic.leader.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.cruxrepublic.leader.MainActivity
import com.cruxrepublic.leader.R
import com.cruxrepublic.leader.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var titles = arrayOf("Top Learners", "Top Skill IQ")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        // TODO: Use the ViewModel
        setUpViewPager(viewpager)
        TabLayoutMediator(tabLayout, viewpager) { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()

    }

    private fun setUpViewPager(viewPager: ViewPager2){
        val pagerAdapter = PagerAdapter(requireActivity())
        pagerAdapter.addFragment(TopLearnersFragment(),"Top Learners")
        pagerAdapter.addFragment(SkillIqFragment(), "Top Skill IQ")

         viewPager.adapter = pagerAdapter
    }

    override fun onStart() {
        super.onStart()
        MainActivity.updateToolbarTitle(requireActivity(), "")
        MainActivity.showBarTitle(requireActivity())
    }

    override fun onResume() {
        super.onResume()
        MainActivity.updateToolbarTitle(requireActivity(),"")
    }
}