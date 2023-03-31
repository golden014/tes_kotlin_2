package com.example.tes_kotlin_2

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this);
        val db = Firebase.firestore
        val tesBt = findViewById<Button>(R.id.button)


        val city = hashMapOf(
            "name" to "Los Angeles",
            "state" to "CA",
            "country" to "USA"
        )

        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

        tesBt.setOnClickListener() {
            // Create a new user with a first and last name

// Add a new document with a generated ID
//            db.collection("tes")
//                .add(user)
//                .addOnSuccessListener {
//                    Log.e("mantepp", "DocumentSnapshot added with ID:")
//                }
//                .addOnFailureListener { e ->
//                    Log.e("tidakk", "Error adding document", e)
//                }
            db.collection("cities").document("LA")
                .set(city)
                .addOnSuccessListener {
                    Log.d(TAG, "DocumentSnapshot successfully written!")
                    tesBt.setText("doneee")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error writing document", e)
                    tesBt.setText("errorrrrr")
                }


        }

    }
}