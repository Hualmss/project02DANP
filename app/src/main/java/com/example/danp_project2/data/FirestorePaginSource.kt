package com.example.danp_project2.data


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await


class FirestorePagingSource (
    private val queryGarbage: Query
) : PagingSource<QuerySnapshot, GarbageFB>() {
    override fun getRefreshKey(state: PagingState<QuerySnapshot, GarbageFB>): QuerySnapshot? = null

    override suspend fun load(params: LoadParams<QuerySnapshot>): LoadResult<QuerySnapshot, GarbageFB> {
        return try {
            val currentPage = params.key ?: queryGarbage.get().await()
            val lastVisibleGarbage = currentPage.documents[currentPage.size() - 1]
            val nextPage = queryGarbage.startAfter(lastVisibleGarbage).get().await()
            LoadResult.Page(
                data = currentPage.toObjects(GarbageFB::class.java),
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
