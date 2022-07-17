package br.com.app5m.mulheremfoco.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.app5m.mulheremfoco.R
import br.com.app5m.mulheremfoco.databinding.ActivityBriefiengBinding
import kotlinx.android.synthetic.main.activity_briefieng.*

class BriefiengActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    lateinit var binding: ActivityBriefiengBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBriefiengBinding.inflate(layoutInflater)
        setContentView(binding.root)






        navController = findNavController(R.id.briefing_nav_host)

        appBarConfiguration = AppBarConfiguration.Builder(
/*            R.id.favoritesFrag,
            R.id.menuFrag, R.id.homeFragment*/
        )
            .build()
        setSupportActionBar(binding.briefiengToolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)

        visibilityNavElements(navController)
    }


    private fun visibilityNavElements(navController: NavController) {


        navController.addOnDestinationChangedListener { _, destination, _ ->
                 when (destination.id) {
                     R.id.loginFragment ->{
                         briefieng_appbar.visibility = View.GONE
                         supportActionBar?.setDisplayShowTitleEnabled(false)
     //                         supportActionBar?.setTitle("Favoritos")
                     }
                     R.id.siginUpFrag ->{
                         briefieng_appbar.visibility = View.VISIBLE
                         supportActionBar?.setDisplayShowTitleEnabled(true)
                         supportActionBar?.setTitle("Cadastre-se")
                     }
                     R.id.recoverPassFrag2 ->{
                         briefieng_appbar.visibility = View.VISIBLE
                         supportActionBar?.setDisplayShowTitleEnabled(true)
                         supportActionBar?.setTitle("Recuperar Senha")
                     }
                     else ->{
                         briefieng_appbar.visibility = View.GONE

                     }
                 }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = navController
        return when (navController.currentDestination?.id) {
            /*   R.id.homeFragment -> {
                   finish()
                   true
               }*/
            else -> navController.navigateUp()
        }
        //Setup appBarConfiguration for back arrow
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    /*override fun onBackPressed() {++++++++++++++++++++++
        when { //If drawer layout is open close that on back pressed
            }
            else -> {
                super.onBackPressed() //If drawer is already in closed condition then go back
            }
        }++++++++++++++++++++++++++++++
    }*/
    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }


}