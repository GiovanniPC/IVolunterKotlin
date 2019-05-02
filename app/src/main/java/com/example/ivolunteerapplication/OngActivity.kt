package com.example.ivolunteerapplication

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class OngActivity : DebugActivity() {

    var ong: Ong? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ong)

        ong = intent.getSerializableExtra("ong") as Ong

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = ong?.name

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var texto = findViewById<TextView>(R.id.nomeOng)
        texto.text = ong?.name

        var texto1 = findViewById<TextView>(R.id.responsavelOng)
        texto1.text = ong?.responsavel

        var texto2 = findViewById<TextView>(R.id.descricaoOng)
        texto2.text = ong?.descricao

    }
}