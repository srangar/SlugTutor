package com.example.srini.slugtutor;

import android.content.Context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class CreateEventActivity extends AppCompatActivity {

    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_activity);

        final Course classData = (Course)getIntent().getSerializableExtra("classData");
        System.out.println(classData);
        final EditText titleEditText = findViewById(R.id.listingTitle);
        final EditText descriptionEditText = findViewById(R.id.listingDescription);
        final Button addButton = findViewById(R.id.addListing);

        Intent i = getIntent();
        final String type = i.getStringExtra("type");

        final FirebaseService firebaseService = new FirebaseService();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!titleEditText.getText().toString().equals("") && !descriptionEditText.getText().toString().equals("")) {
                    Intent i = new Intent();
                    switch (type) {
                        case "student":
                            i = new Intent(context, TabStudentActivity.class);
                            firebaseService.addStudentListing(titleEditText.getText().toString(),
                                    descriptionEditText.getText().toString(), classData);
                            break;
                        case "group":
                            i = new Intent(context, TabGroupActivity.class);
                            firebaseService.addGroupListing(titleEditText.getText().toString(),
                                    descriptionEditText.getText().toString(), classData);
                            break;
                        case "tutor":
                            i = new Intent(context, TabTutorActivity.class);
                            firebaseService.addTutorListing(titleEditText.getText().toString(),
                                    descriptionEditText.getText().toString(), classData);
                            break;
                    }
                    i.putExtra("classData", classData);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }

            }
        });
    }

}
