package com.example.ivolunteerapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.content.Context
import android.support.v7.widget.*



class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var ongs = listOf<Ong>()
    var recyclerOngs: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args:Bundle? = intent.extras

        val nome = args?.getString("nome")

        Toast.makeText(context, "Parâmetro: $nome", Toast.LENGTH_LONG).show()


        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title="IVolunteer APP"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerOngs = findViewById<RecyclerView>(R.id.recyclerOngs)
        recyclerOngs?.layoutManager = LinearLayoutManager(context)
        recyclerOngs?.itemAnimator = DefaultItemAnimator()
        recyclerOngs?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()

        taskOngs()
    }

    fun taskOngs() {

        ongs = OngService.getOngs(context)

        recyclerOngs?.adapter = OngAdapter(ongs) {onClickOng(it)}
    }

    fun onClickOng(ong: Ong) {
        Toast.makeText(context, "Clicou ong ${ong.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, OngActivity::class.java)
        intent.putExtra("ong", ong)
        startActivity(intent)
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
                setContentView(R.layout.activity_tela_inicial)

                val args:Bundle? = intent.extras

                val nome = args?.getString("nome")

                val numero = intent.getIntExtra("nome",0)

                Toast.makeText(context, "Parâmetro: $nome", Toast.LENGTH_LONG).show()
                Toast.makeText(context, "Numero: $numero", Toast.LENGTH_LONG).show()

                var toolbar = findViewById<Toolbar>(R.id.toolbar)
                setSupportActionBar(toolbar)

                supportActionBar?.title="IVolunteer APP"

                supportActionBar?.setDisplayHomeAsUpEnabled(true)

                configuraMenuLateral()

                recyclerOngs = findViewById<RecyclerView>(R.id.recyclerOngs)
                recyclerOngs?.layoutManager = LinearLayoutManager(context)
                recyclerOngs?.itemAnimator = DefaultItemAnimator()
                recyclerOngs?.setHasFixedSize(true)
            }
            R.id.nav_ong -> {
                Toast.makeText(this, "Clicou ONGs", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.about)

                var toolbar = findViewById<Toolbar>(R.id.toolbar)
                setSupportActionBar(toolbar)

                supportActionBar?.title="ONGs"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)

                configuraMenuLateral()
            }
            R.id.nav_voluntario -> {
                Toast.makeText(this, "Clicou Voluntarios", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.about)

                val toolbar = findViewById<Toolbar>(R.id.toolbar)
                setSupportActionBar(toolbar)

                supportActionBar?.title="Voluntarios"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)

                configuraMenuLateral()
            }
            R.id.nav_about -> {
                Toast.makeText(this, "Clicou Sobre", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.about)

                var toolbar = findViewById<Toolbar>(R.id.toolbar)
                setSupportActionBar(toolbar)

                supportActionBar?.title="Sobre"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)

                configuraMenuLateral()
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
            setContentView(R.layout.about)

            val toolbar = findViewById<Toolbar>(R.id.toolbar)
            setSupportActionBar(toolbar)

            supportActionBar?.title="About"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        if(id == R.id.action_logout){

            Toast.makeText(this, "Você saiu!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        return super.onOptionsItemSelected(item)
    }
}
