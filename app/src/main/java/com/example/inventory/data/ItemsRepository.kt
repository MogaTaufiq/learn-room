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

import kotlinx.coroutines.flow.Flow

/**
 * Interface `ItemsRepository` yang menyediakan metode untuk melakukan operasi insert, update, delete, 
 * dan retrieve (pengambilan) data `Item` dari sumber data yang diberikan.
 */
interface ItemsRepository {
    
    /**
     * Mengambil semua item dari sumber data dan mengembalikannya sebagai `Flow` dari daftar `Item`.
     * Metode ini akan mengalirkan daftar item secara real-time setiap kali ada perubahan data.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Mengambil satu item berdasarkan `id` dari sumber data dan mengembalikannya sebagai `Flow` dari `Item?`.
     * Jika item dengan `id` yang diberikan tidak ditemukan, maka mengembalikan nilai `null`.
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Menyisipkan (insert) item baru ke dalam sumber data.
     * Fungsi ini bersifat `suspend` untuk mendukung pemanggilan non-blocking.
     */
    suspend fun insertItem(item: Item)

    /**
     * Menghapus (delete) item yang diberikan dari sumber data.
     * Fungsi ini bersifat `suspend` untuk mendukung pemanggilan non-blocking.
     */
    suspend fun deleteItem(item: Item)

    /**
     * Memperbarui (update) data item yang sudah ada dalam sumber data.
     * Fungsi ini bersifat `suspend` untuk mendukung pemanggilan non-blocking.
     */
    suspend fun updateItem(item: Item)
}
