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

/**
 * AppContainer adalah interface yang berfungsi sebagai kontainer aplikasi untuk
 * dependency injection, yang memfasilitasi penyediaan instance dari objek yang dibutuhkan.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository // Mendeklarasikan properti itemsRepository yang akan diimplementasikan oleh class lain
}

/**
 * Implementasi [AppContainer] yang menyediakan instance dari [OfflineItemsRepository].
 */
class AppDataContainer(private val context: Context) : AppContainer {

    /**
     * Implementasi dari itemsRepository yang akan memberikan instance [ItemsRepository].
     * Menggunakan delegasi `by lazy` untuk memastikan bahwa itemsRepository hanya
     * diinisialisasi saat pertama kali diakses.
     */
    override val itemsRepository: ItemsRepository by lazy {
        // Membuat instance OfflineItemsRepository dengan mengakses itemDao dari database
        // InventoryDatabase. itemDao ini diambil dari database yang disediakan oleh
        // InventoryDatabase dengan parameter context.
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
