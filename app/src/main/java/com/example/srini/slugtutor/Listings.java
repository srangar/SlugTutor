package com.example.srini.slugtutor;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Listings extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listings);



        FirebaseService firebaseService = new FirebaseService();

        firebaseService.getUserGroupListings(new CallbackListings() {
            @Override
            public void callback(List<Listing> listings) {

            }
        });

        firebaseService.getGroupListings(new CallbackListings() {
            @Override
            public void callback(List<Listing> listings) {
                
            }
        });
    }
}