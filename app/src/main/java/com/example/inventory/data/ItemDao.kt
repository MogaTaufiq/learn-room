/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Anda tidak diperbolehkan menggunakan file ini kecuali sesuai dengan ketentuan yang diatur dalam lisensi tersebut.
 * Anda dapat memperoleh salinan lisensi di:
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Kecuali diharuskan oleh hukum yang berlaku atau disepakati secara tertulis, perangkat lunak ini
 * didistribusikan dengan ketentuan "APA ADANYA", tanpa jaminan apa pun, baik secara tersurat maupun tersirat.
 * Lihat lisensi untuk aturan spesifik mengenai izin dan batasan di bawah lisensi ini.
 */

package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Interface ItemDao mendefinisikan metode-metode akses data (CRUD) untuk tabel Item dalam database.
@Dao
interface ItemDao {

    // Menyisipkan (insert) item baru ke dalam tabel. Jika terdapat konflik (misalnya, ID sudah ada), akan diabaikan.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    // Memperbarui (update) data item yang sudah ada dalam tabel.
    @Update
    suspend fun update(item: Item)

    // Menghapus (delete) data item dari tabel.
    @Delete
    suspend fun delete(item: Item)

    // Mengambil satu item berdasarkan ID-nya, dan mengembalikannya sebagai Flow untuk mendapatkan pembaruan data secara real-time.
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // Mengambil semua item dari tabel "items", diurutkan secara alfabetis berdasarkan nama, dan mengembalikannya sebagai Flow dari daftar Item.
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}
