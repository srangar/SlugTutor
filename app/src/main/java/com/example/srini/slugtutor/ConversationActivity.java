package com.example.srini.slugtutor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ConversationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        final String recipientName = getIntent().getStringExtra("name");
        final String recipientID = getIntent().getStringExtra("userID");

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle(recipientName);
        actionBar.setSubtitle("Slug Tutor");

        final ListView conversation = findViewById(R.id.conversation);
        final EditText messageEditText = findViewById(R.id.messageEditText);
        Button sendButton = findViewById(R.id.sendMessage);

        System.out.println(recipientID);
        final FirebaseService firebaseService = new FirebaseService();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!messageEditText.getText().toString().equals("")) {
                    firebaseService.sendMessage(recipientID, messageEditText.getText().toString());
                    messageEditText.setText("");
                }
            }
        });

        DatabaseReference conversationSocket = firebaseService.getConversationSocket(recipientID);

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> messages = new ArrayList<>();
                for (DataSnapshot message : dataSnapshot.getChildren()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(message.getKey());
                    sb.append("|");

                    for (DataSnapshot messageData : message.getChildren()) {
                        sb.append(messageData.getValue());
                        if (messageData.getKey().equals("message")) {
                            sb.append("|");
                        }
                    }

                    messages.add(sb.toString());
                }

                ConversationActivityAdapter conversationActivityAdapter =
                        new ConversationActivityAdapter(ConversationActivity.this, messages, firebaseService);
                conversation.setAdapter(conversationActivityAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        conversationSocket.addValueEventListener(postListener);

    }
}
