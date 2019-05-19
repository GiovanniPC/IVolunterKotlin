package com.example.ivolunteerapplication

import android.arch.persistence.room.Room

object DatabaseManager {

    // singleton
    private var dbInstance: IVoDatabase
    init {
        val appContext = IVoApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext, // contexto global
            IVoDatabase::class.java, // Referência da classe do banco
            "lms.sqlite" // nome do arquivo do banco
        ).build()
    }

    fun getongDAO(): OngDAO {
        return dbInstance.ongDAO()
    }
}