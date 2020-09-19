package com.cruxrepublic.leader

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = toolbar
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
        setupActionBarWithNavController(navController)

        tvSubmit.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_submitFragment)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

    companion object{
        fun updateToolbarTitle(activity: Activity, title: String){
            activity.toolbar.title = title
        }
        fun hideToolBarTitle(activity: Activity){
            activity.leaderAppBar.visibility = View.GONE

        }
        fun showBarTitle(activity: Activity){
            activity.leaderAppBar.visibility = View.VISIBLE

        }
    }
}