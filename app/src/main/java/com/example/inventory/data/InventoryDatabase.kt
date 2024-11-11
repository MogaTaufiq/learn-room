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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Menandai class InventoryDatabase sebagai database Room dan mendefinisikan entitas (table) serta versinya
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    // Fungsi abstrak yang menyediakan akses ke DAO (Data Access Object) untuk entitas Item
    abstract fun itemDao(): ItemDao

    companion object {
        // Menggunakan anotasi @Volatile untuk memastikan bahwa perubahan pada Instance segera terlihat ke thread lain
        @Volatile
        private var Instance: InventoryDatabase? = null

        // Fungsi untuk mendapatkan instance database. Jika sudah ada instance, maka akan dikembalikan;
        // jika tidak, akan dibuat instance baru.
        fun getDatabase(context: Context): InventoryDatabase {
            // Mengembalikan instance yang ada, atau membuat instance baru jika belum ada (singleton pattern)
            return Instance ?: synchronized(this) {
                // Membuat database menggunakan Room dengan nama "item_database"
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build().also { Instance = it } // Menyimpan instance baru ke dalam variabel Instance
            }
        }
    }
}
