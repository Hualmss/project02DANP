package com.example.danp_project2.data

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore


class FireBaseMG {
    private lateinit var database: DatabaseReference

    var db = FirebaseFirestore.getInstance()


    fun getGarbages(applicationContext: Context) {

        db.collection("garbage")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d("", document.id + " => " + document.data)

                        garbageList += "asd"
                    }


                } else {
                    Log.w("", "Error getting documents.", task.exception)

                }
            }
    }
}


