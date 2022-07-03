package com.example.danp_project2.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GarbageRepositoryFireBase {
    fun getGarbage():Flow<PagingData<GarbageFB>>
}