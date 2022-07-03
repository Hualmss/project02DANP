package com.example.danp_project2.views.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.danp_project2.data.GarbageViewModelFireBase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
//import androidx.compose.foundation.lazy.items
import androidx.paging.compose.items
import androidx.paging.LoadState.Loading
import com.example.danp_project2.data.GarbageEntity
import com.example.danp_project2.views.components.CardGarbegeHouse
import com.example.danp_project2.views.components.GCard


@Composable
@InternalCoroutinesApi
@ExperimentalPagingApi
@ExperimentalCoroutinesApi
fun WorldGarbage(
    navController: NavController,
    viewModel: GarbageViewModelFireBase = hiltViewModel()
) {//https://stackoverflow.com/questions/66056031/singletoncomponent-is-missing-a-parent-declaration
    Scaffold(
        topBar = {
            //ProductsTopBar()
        }
    ) {
        val products = viewModel.products.collectAsLazyPagingItems()
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "asd")
            LazyColumn {
                items(
                    items = products,
                ) { product ->
                    product?.let {
                        GCard(
                            garbage = product,

                        )
                    }
                }
            }

            products.apply {
                when {

                }
            }
        }
    }
}