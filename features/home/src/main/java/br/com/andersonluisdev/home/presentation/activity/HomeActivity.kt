package br.com.andersonluisdev.home.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.andersonluisdev.home.R
import br.com.andersonluisdev.home.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavController()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setupNavController() {
        setSupportActionBar(binding.homeToolbar)
        val homeContainerView = supportFragmentManager
            .findFragmentById(R.id.homeContainer) as NavHostFragment
        navController = homeContainerView.navController
        setupActionBarWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.homeToolbar.title = destination.label
            if (destination.id == R.id.orderDetailsFragment) {
                binding.homeToolbar.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        br.com.andersonluisdev.common.R.color.grayBackground
                    )
                )
                window.statusBarColor = ContextCompat.getColor(
                    this,
                    br.com.andersonluisdev.common.R.color.grayBackground
                )
            } else {
                binding.homeToolbar.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        br.com.andersonluisdev.common.R.color.white
                    )
                )
            }
        }
    }
}
