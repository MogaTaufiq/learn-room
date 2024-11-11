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

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class `Item` merepresentasikan sebuah entitas atau baris data dalam tabel database.
 * Setiap objek `Item` akan menjadi satu baris di dalam tabel "items" pada database.
 */
@Entity(tableName = "items") // Menandai bahwa class ini adalah sebuah entitas dalam Room dengan nama tabel "items"
data class Item(
    @PrimaryKey(autoGenerate = true) // Menentukan kolom `id` sebagai primary key dan mengaturnya untuk menghasilkan nilai secara otomatis
    val id: Int = 0,                // Kolom `id`, dengan nilai default 0, digunakan sebagai primary key unik untuk setiap item
    val name: String,                // Kolom `name`, digunakan untuk menyimpan nama item
    val price: Double,               // Kolom `price`, digunakan untuk menyimpan harga item
    val quantity: Int                // Kolom `quantity`, digunakan untuk menyimpan jumlah stok item
)
