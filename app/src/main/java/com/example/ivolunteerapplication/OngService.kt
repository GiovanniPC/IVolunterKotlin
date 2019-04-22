package com.example.ivolunteerapplication

import android.content.Context

object OngService {

    fun getOngs(context: Context): List<Ong> {
        val ongs = mutableListOf<Ong>()

        for (i in 1..10) {
            val o = Ong()
            o.nome = "Ong $i"
            o.ementa = "Ementa Ong $i"
            o.criador = "Criador da Ong $i"
            o.foto = "https://cdn.pixabay.com/photo/2018/01/18/20/42/pencil-3091204_1280.jpg"
            ongs.add(o)
        }

        return ongs
    }

}