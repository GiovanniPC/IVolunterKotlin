package com.example.ivolunteerapplication

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object OngService {


    val host = "https://ivolunteer-rest-api.herokuapp.com"
    val TAG = "ivolunteer-rest-api"

    fun getOngs(context: Context): List<Ong> {
        var ongs = ArrayList<Ong>()
        if (AndroidUtils.isInternetDisponivel(context)) {

            val url = "$host/saude"
            val json = HttpHelper.get(url)
            ongs = parserJson(json)

            for (o in ongs) {
                saveOffline(o)
            }

            return ongs

        } else {

            val dao = DatabaseManager.getongDAO()
            val ongs = dao.findAll()

            return ongs
        }
    }

    fun save(ong: Ong): Response {

        if (AndroidUtils.isInternetDisponivel(IVoApplication.getInstance().applicationContext)) {
            val json = HttpHelper.post("$host/signup/ong", ong.toJson())
            return parserJson<Response>(json)
        } else {
            val dao = DatabaseManager.getongDAO()
            dao.insert(ong)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }
    }

    fun saveOffline(ong: Ong) : Boolean {
        val dao = DatabaseManager.getongDAO()

        if (! existeOng(ong)) {
            dao.insert(ong)
        }

        return true

    }

    fun getOng (context: Context, id: String): Ong? {

        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/account-details/${id}"
            val json = HttpHelper.get(url)
            val ong = parserJson<Ong>(json)

            return ong
        } else {
            val dao = DatabaseManager.getongDAO()
            val ong = dao.getById(id)
            return ong
        }

    }

    fun existeOng(ong: Ong): Boolean {
        val dao = DatabaseManager.getongDAO()
        return dao.getById(ong.id) != null
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}