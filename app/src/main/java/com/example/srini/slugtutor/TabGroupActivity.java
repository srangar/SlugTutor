package com.example.srini.slugtutor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class TabGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        final String isUser = getIntent().getStringExtra("isUser");
        boolean isUserListings = Boolean.valueOf(isUser);
        final Course classData = (Course)getIntent().getSerializableExtra("classData");
        System.out.println(classData);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        // Set Basic ui
        setSupportActionBar(toolbar);
        if(classData != null)
        getSupportActionBar().setTitle(classData.getCourseNum());
        toolbar.setSubtitle((isUserListings ? "My Group Listings" : "Group Listings"));
        //  System.out.println(getIntent().getParcelableExtra("classData"));
        //isUser = getIntent().getStringExtra("isUser");

        final ListView listView = findViewById(R.id.listView);
        final View navigator = findViewById(R.id.navigator);
        final Button studentButton = navigator.findViewById(R.id.student_button);
        final Button tutorButton = navigator.findViewById(R.id.tutor_button);
        final Button groupButton = navigator.findViewById(R.id.group_button);
        groupButton.setBackground(ContextCompat.getDrawable(this, R.drawable.tab_main_background));
        final FloatingActionButton postingButton = findViewById(R.id.floatingActionButton);

        FirebaseService firebaseService = new FirebaseService();
        if(isUserListings) {
            postingButton.hide();
            firebaseService.getUserGroupListings(new CallbackListings() {
                @Override
                public void callback(List<Listing> listings) {
                    CustomAdapter adapter = new CustomAdapter(TabGroupActivity.this, listings);
                    TabListingsAdapter tabListingsAdapter = new TabListingsAdapter(TabGroupActivity.this, listings, true);
                    listView.setAdapter(tabListingsAdapter);
                }
            });
        }
        else {
            firebaseService.getCourseGroupListings(classData, new CallbackListings() {
                @Override
                public void callback(List<Listing> listings) {
                    CustomAdapter adapter = new CustomAdapter(TabGroupActivity.this, listings);
                    TabListingsAdapter tabListingsAdapter = new TabListingsAdapter(TabGroupActivity.this, listings, false);
                    listView.setAdapter(tabListingsAdapter);
                }

            });
        }

        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TabGroupActivity.this, TabStudentActivity.class);
                i.putExtra("isUser", isUser);
                i.putExtra("classData", classData);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });

        tutorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TabGroupActivity.this, TabTutorActivity.class);
                i.putExtra("isUser", isUser);
                i.putExtra("classData", classData);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        postingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TabGroupActivity.this, CreateEventActivity.class);
                i.putExtra("type","group");
                i.putExtra("classData", classData);
                startActivity(i);
            }
        });
    }
}
