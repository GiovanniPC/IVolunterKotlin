package com.example.ivolunteerapplication

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object OngService {


    val host = "https://ivolunteer-rest-api.herokuapp.com"
    val TAG = "ivolunteer-rest-api"

    fun getOngs(context: Context): List<Ong> {

        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/saude"
            val json = HttpHelper.get(url)
            return parserJson(json)
        } else {
            return ArrayList<Ong>()
        }
    }

    fun save(ong: Ong): Response {
        val json = HttpHelper.post("$host/signup/ong", ong.toJson())
        return parserJson<Response>(json)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}