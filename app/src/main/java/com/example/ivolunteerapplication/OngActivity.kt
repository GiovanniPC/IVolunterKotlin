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

        supportActionBar?.title = ong?.nome

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var texto = findViewById<TextView>(R.id.nomeOng)
        texto.text = ong?.nome
        var imagem = findViewById<ImageView>(R.id.imagemOng)
        Picasso.with(this).load(ong?.foto).fit().into(imagem,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() { }
            })
    }
}