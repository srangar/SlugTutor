package com.example.srini.slugtutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TabListingExpanded extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_expanded);

        final Listing listing = (Listing) getIntent().getSerializableExtra("listing");
        boolean isUserListing = getIntent().getBooleanExtra("isUserListing", false);

        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        Button contact = findViewById(R.id.contact);

        if (isUserListing) {
            contact.setVisibility(View.GONE);
        }

        title.setText(listing.getName());
        description.setText(listing.getDescription());

        final FirebaseService firebaseService = new FirebaseService();
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSuccessful = firebaseService.createConversation(listing.getOwner());
                if (!isSuccessful) {
                    Toast.makeText(TabListingExpanded.this, "Can't contact yourself!", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseService.getName(listing.getOwner(), new CallbackName() {
                    @Override
                    public void callback(String name) {
                        Intent i = new Intent(TabListingExpanded.this, ConversationActivity.class);
                        i.putExtra("userID", listing.getOwner());
                        i.putExtra("name", name);
                        startActivity(i);
                    }
                });

            }
        });
    }
}
