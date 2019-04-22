package com.example.ivolunteerapplication

import java.io.Serializable

class Ong : Serializable {

    var id:Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var criador = ""

    override fun toString(): String {
        return "Ong(nome='$nome')"
    }
}