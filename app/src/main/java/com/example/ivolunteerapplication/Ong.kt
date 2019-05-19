package com.example.ivolunteerapplication

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable
import com.google.gson.GsonBuilder

val dao = DatabaseManager.getongDAO()
var newid = dao.bigId() + 1
var id = ""

fun testOn() : String{
    if (AndroidUtils.isInternetDisponivel(IVoApplication.getInstance().applicationContext)) {
        return id
    } else {
        return newid
    }
}

@Entity(tableName = "ong")
class Ong : Serializable {

    @PrimaryKey
    var id = testOn()
    var name = ""
    var username = ""
    var email = ""
    var responsavel = ""
    var data_abertura = ""
    var phone = ""
    var address = ""
    var city = ""
    var state = ""
    var descricao = ""
    var cnpj = ""
    var area_atuacao = ""
    var password = ""
    var status = "true"


    override fun toString(): String {
        return "Ong(nome='$name')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}