//package com.example.ivolunteerapplication
//
//import android.content.Context
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//
//object LoginService {
//
//    val host = "https://ivolunteer-rest-api.herokuapp.com/"
//    val TAG = "ivolunteer-rest-api"
//
//    fun getUser(context: Context): List<Ong> {
//
//
//        if (AndroidUtils.isInternetDisponivel(context)) {
//            val url = "$host/disciplinas"
//            val json = HttpHelper.get(url)
//            return parserJson(json)
//        } else {
//            return ArrayList<Disciplina>()
//        }
//    }
//
//    inline fun <reified T> parserJson(json: String): T {
//        val type = object : TypeToken<T>(){}.type
//        return Gson().fromJson<T>(json, type)
//    }
//}