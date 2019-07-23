package com.example.deskdeliverybyhungerbox

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.GridView
import android.widget.ImageButton
import android.widget.AdapterView



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var foodType1:FoodType = FoodType("South Indian",R.mipmap.ic_launcher_foreground_southindian)
    private var foodType2:FoodType = FoodType("North Indian",R.mipmap.ic_launcher_foreground_northindian)
    private var foodType3:FoodType = FoodType("Chinese",R.mipmap.ic_launcher_foreground_chinesefood)
    private var foodType4:FoodType = FoodType("Juice",R.mipmap.ic_launcher_foreground_juice)
    private var foodTypes:Array<FoodType> = arrayOf(foodType1,foodType2,foodType3,foodType4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleGrid = findViewById<GridView>(R.id.grid_view)
        // Create an object of CustomAdapter and set Adapter to GridView
        val customAdapter = CustomAdapter(applicationContext, foodTypes)

        simpleGrid.adapter  = customAdapter
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        simpleGrid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // set an Intent to Another Activity
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent) // start Intent
        }

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.nav_Recharge -> {

            }
            R.id.nav_contactUs-> {

            }
            R.id.nav_rateUs -> {

            }
            R.id.nav_DeskDelivery -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
