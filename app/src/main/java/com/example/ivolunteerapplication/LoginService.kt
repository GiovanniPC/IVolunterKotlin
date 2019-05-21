package com.example.ivolunteerapplication

object LoginService {

    val host = "https://ivolunteer-rest-api.herokuapp.com"

    fun login(ong: OngLogin): String {

        return HttpHelper.post("$host/login/ong", ong.toJson())

    }

//    fun saveOffline(ong: Ong) : Boolean {
//        val dao = DatabaseManager.getongDAO()
//
//        if (! existeOng(ong)) {
//            dao.insert(ong)
//        }
//
//        return true
//
//    }

}