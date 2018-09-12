package com.example.srini.slugtutor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MyConversationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_conversations);

        final ListView conversationsList = findViewById(R.id.conversationsList);

        FirebaseService firebaseService = new FirebaseService();
        firebaseService.getConversations(new CallbackConversations() {
            @Override
            public void callback(List<String> names) {

                MyConversationsAdapter myConversationsAdapter = new MyConversationsAdapter(MyConversationsActivity.this, names);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(MyConversationsActivity.this,
                        android.R.layout.simple_list_item_1, names);
                conversationsList.setAdapter(myConversationsAdapter);
            }
        });

    }
}
