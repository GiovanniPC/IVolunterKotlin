package com.example.ivolunteerapplication

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

// anotação define a lista de entidades e a versão do banco
@Database(entities = arrayOf(Ong::class), version = 1)
abstract class IVoDatabase: RoomDatabase() {
    abstract fun ongDAO(): OngDAO
}