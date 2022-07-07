package com.example.danp_project2.data.DataForFIrebase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
@ExperimentalCoroutinesApi
class GarbageReposityImpl @Inject constructor(
    private val source: FirestorePagingSource,
    private val config: PagingConfig
     ): GarbageRepositoryFireBase {

    override fun getGarbage()= Pager(
        config = config
    ) {
        source
    }.flow
}