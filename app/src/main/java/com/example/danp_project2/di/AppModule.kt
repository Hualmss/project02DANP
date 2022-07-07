package com.example.danp_project2.di

import androidx.paging.PagingConfig
import com.example.danp_project2.data.DataForFIrebase.FirestorePagingSource
import com.example.danp_project2.data.DataForFIrebase.GarbageRepositoryFireBase
import com.example.danp_project2.data.DataForFIrebase.GarbageReposityImpl
import com.example.danp_project2.dmn.GetGarbage
import com.example.danp_project2.dmn.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import dagger.hilt.components.SingletonComponent
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.Query.Direction.ASCENDING
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideQueryProductsByName() = Firebase.firestore
        .collection("garbage")
        .orderBy("name", ASCENDING)
        .limit(10L)

    @Provides
    fun provideFirestorePagingSource(
        queryProductsByName: Query
    ) = FirestorePagingSource(queryProductsByName)

    @Provides
    fun providePagingConfig() = PagingConfig(
        pageSize = 10L.toInt()
    )

    @Provides
    fun provideProductsRepository(
        source: FirestorePagingSource,
        config: PagingConfig
    ): GarbageRepositoryFireBase = GarbageReposityImpl(source, config)

    @Provides
    fun provideUseCases(repository: GarbageRepositoryFireBase) = UseCases(
        getProducts = GetGarbage(repository)
    )
}