package br.com.andersonluisdev.home.presentation.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.andersonluisdev.home.R
import br.com.andersonluisdev.home.databinding.ActivityHomeBinding
import br.com.andersonluisdev.home.presentation.dataui.MyProfileDataUi

class HomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = intent?.getParcelableExtra<MyProfileDataUi>("USER_PROFILE")
        Log.d("Challenge", user.toString())

        setupNavController()
    }

    private fun setupNavController() {
        setSupportActionBar(binding.homeToolbar)
        val homeContainerView = supportFragmentManager
            .findFragmentById(R.id.homeContainer) as NavHostFragment
        navController = homeContainerView.navController
        setupActionBarWithNavController(navController)
    }
}
