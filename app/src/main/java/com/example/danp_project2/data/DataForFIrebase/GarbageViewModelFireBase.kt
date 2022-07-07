package com.example.danp_project2.data.DataForFIrebase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import com.example.danp_project2.dmn.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
@ExperimentalPagingApi
class GarbageViewModelFireBase  @Inject constructor(
    useCases: UseCases
): ViewModel() {
    val products = useCases.getProducts().cachedIn(viewModelScope)
}