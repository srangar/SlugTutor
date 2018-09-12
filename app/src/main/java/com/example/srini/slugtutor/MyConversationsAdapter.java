package com.example.srini.slugtutor;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyConversationsAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> items;

    public MyConversationsAdapter(Context context, List<String> items) {
        super(context, 0, items);
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }

        TextView contactName = convertView.findViewById(R.id.contactName);
        String item = items.get(position);

        System.out.println(item);

        if (item != null) {
            final String[] tokens = item.split(",");
            contactName.setText(tokens[0]);

            contactName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, ConversationActivity.class);
                    i.putExtra("name", tokens[0]);
                    i.putExtra("userID", tokens[1]);
                    context.startActivity(i);
                }
            });
        }
        return convertView;
    }
}
