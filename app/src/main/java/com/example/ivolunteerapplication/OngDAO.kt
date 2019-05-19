package com.example.ivolunteerapplication

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface OngDAO {
    @Query("SELECT * FROM ong where id = :id")
    fun getById(id: String) : Ong?

    @Query("SELECT * FROM ong")
    fun findAll(): List<Ong>

    @Insert
    fun insert(ong: Ong)

    @Query("SELECT id FROM ong ORDER BY id DESC LIMIT 1;")
    fun bigId() : String
}