package com.app.testexam.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.app.testexam.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController


        val inflater = navController.navInflater


        val graph = inflater.inflate(R.navigation.nav_graph_global).apply {
            setStartDestination(R.id.nav_main)
        }

        navController.graph = graph
        NavigationUI.setupWithNavController(findViewById(R.id.toolbar), navController, null)
        changeDestination()
    }

    private fun changeDestination() {
        navController.addOnDestinationChangedListener{_,destionation,_->
            when(destionation.id){
                R.id.payFragment -> {findViewById<Toolbar>(R.id.toolbar).title = null}
            }
        }
    }
}