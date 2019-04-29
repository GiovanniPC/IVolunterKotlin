package com.example.ivolunteerapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast



class OActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ongs)


        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title="Ongs"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()


    }


    private fun configuraMenuLateral () {
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var menuLateral = findViewById<DrawerLayout>(R.id.layourMenuLateral)

        var toogle = ActionBarDrawerToggle(this, menuLateral, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        menuLateral.addDrawerListener(toogle)
        toogle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.menu_lateral)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                Toast.makeText(this, "Clicou Home", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, TelaInicialActivity::class.java))

            }
            R.id.nav_ong -> {
                Toast.makeText(this, "Clicou ONGs", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, OActivity::class.java))

            }
            R.id.nav_voluntario -> {
                Toast.makeText(this, "Clicou Voluntarios", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, VActivity::class.java))

            }
            R.id.nav_about -> {
                Toast.makeText(this, "Clicou Sobre", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, SobreActivity::class.java))
            }
            R.id.action_logout -> {
                Toast.makeText(this, "Você saiu!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        val drawer = findViewById<DrawerLayout>(R.id.layourMenuLateral)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if(id == R.id.action_buscar){
            Toast.makeText(this, "Clicou Buscar!", Toast.LENGTH_LONG).show()
        }
        if(id == R.id.action_atualizar){
            Toast.makeText(this, "Entrou em About!", Toast.LENGTH_LONG).show()
        }
        if(id == R.id.action_logout){

            Toast.makeText(this, "Você saiu!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        return super.onOptionsItemSelected(item)
    }
}
