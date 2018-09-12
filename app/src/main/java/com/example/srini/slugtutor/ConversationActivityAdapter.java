package com.example.srini.slugtutor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ConversationActivityAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> messages;
    FirebaseService firebaseService;

    public ConversationActivityAdapter(Context context, List<String> messages, FirebaseService firebaseService) {
        super(context, 0, messages);
        this.context = context;
        this.messages = messages;
        this.firebaseService = firebaseService;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_message, parent, false);
        }

        TextView receiver = convertView.findViewById(R.id.receiver);
        TextView sender = convertView.findViewById(R.id.sender);


        String messageData = messages.get(position);

        if (messageData != null) {
            String[] messageTokens = messageData.split("\\|", 3);
            String date = messageTokens[0];
            String message = messageTokens[1];
            String owner = messageTokens[2];

            if (firebaseService.getUserID().equals(owner)) {
                receiver.setVisibility(View.INVISIBLE);
                sender.setText(message);
            } else {
                sender.setVisibility(View.INVISIBLE);
                receiver.setText(message);
            }

            System.out.println(date);
            System.out.println(message);
            System.out.println(owner);

        }


        return convertView;
    }
}
