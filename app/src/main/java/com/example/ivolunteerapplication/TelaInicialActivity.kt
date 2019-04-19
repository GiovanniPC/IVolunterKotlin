package com.example.ivolunteerapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


class TelaInicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title="IVolunteer APP"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
