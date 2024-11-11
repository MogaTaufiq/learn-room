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

package com.example.inventory.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.inventory.InventoryApplication
import com.example.inventory.ui.home.HomeViewModel
import com.example.inventory.ui.item.ItemDetailsViewModel
import com.example.inventory.ui.item.ItemEditViewModel
import com.example.inventory.ui.item.ItemEntryViewModel

/**
 * Menyediakan Factory untuk membuat instance ViewModel untuk keseluruhan aplikasi Inventory.
 */
object AppViewModelProvider {

    // Factory untuk membuat ViewModel menggunakan `viewModelFactory`
    val Factory = viewModelFactory {
        
        // Initializer untuk `ItemEditViewModel`
        initializer {
            // Membuat instance `ItemEditViewModel` dengan `SavedStateHandle` untuk menyimpan
            // dan mengelola data UI yang perlu dipertahankan selama perubahan konfigurasi.
            ItemEditViewModel(
                this.createSavedStateHandle()
            )
        }

        // Initializer untuk `ItemEntryViewModel`
        initializer {
            // Membuat instance `ItemEntryViewModel` dan menyuntikkan `itemsRepository`
            // dari container `InventoryApplication` untuk akses data Item.
            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
        }

        // Initializer untuk `ItemDetailsViewModel`
        initializer {
            // Membuat instance `ItemDetailsViewModel` dengan `SavedStateHandle` untuk pengelolaan data UI.
            ItemDetailsViewModel(
                this.createSavedStateHandle()
            )
        }

        // Initializer untuk `HomeViewModel`
        initializer {
            // Membuat instance `HomeViewModel` tanpa parameter tambahan.
            HomeViewModel()
        }
    }
}

/**
 * Fungsi ekstensi untuk mendapatkan objek [Application] dan mengembalikan instance dari
 * [InventoryApplication].
 */
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)
