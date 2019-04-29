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
                o.foto = "http://www.rosapenido.com.br/wp-content/uploads/2018/09/Quais-s%C3%A3o-os-tipos-de-ONGs-no-Brasil-rosa-penido.jpg"
                ongs.add(o)
            }

        return ongs
    }

}