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
 * Implementasi dari interface `ItemsRepository` yang beroperasi pada data offline,
 * dengan menggunakan `ItemDao` sebagai sumber data lokal.
 */
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    
    /**
     * Mengambil semua item dari `itemDao` dalam bentuk `Flow` dari daftar `Item`.
     * Menggunakan implementasi `getAllItems` dari `ItemDao`.
     */
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    /**
     * Mengambil satu item berdasarkan `id` dari `itemDao` dalam bentuk `Flow` dari `Item?`.
     * Menggunakan implementasi `getItem` dari `ItemDao`.
     */
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    /**
     * Menyisipkan (insert) item baru ke dalam `itemDao`.
     * Fungsi ini dijalankan secara asynchronous dengan menggunakan `suspend`.
     */
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    /**
     * Menghapus (delete) item dari `itemDao`.
     * Fungsi ini dijalankan secara asynchronous dengan menggunakan `suspend`.
     */
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    /**
     * Memperbarui (update) data item yang sudah ada dalam `itemDao`.
     * Fungsi ini dijalankan secara asynchronous dengan menggunakan `suspend`.
     */
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
