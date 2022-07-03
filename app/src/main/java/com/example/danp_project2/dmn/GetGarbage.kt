package com.example.danp_project2.dmn

import com.example.danp_project2.data.GarbageRepositoryFireBase

class GetGarbage (
    private val repository: GarbageRepositoryFireBase
){
        operator fun invoke() = repository.getGarbage()
    }
