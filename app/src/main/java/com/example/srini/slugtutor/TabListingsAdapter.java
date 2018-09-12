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

public class TabListingsAdapter extends ArrayAdapter<Listing> {

    private List<Listing> items;
    private Context context;
    private boolean isUserListing;

    public TabListingsAdapter(Context context, List<Listing> items, boolean isUserListing) {
        super(context, 0, items);
        this.items = items;
        this.context = context;
        this.isUserListing = isUserListing;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_listing, parent, false);
        }

        final Listing listing = items.get(position);

        TextView title = convertView.findViewById(R.id.title);
        TextView description = convertView.findViewById(R.id.description);

        if (listing != null) {
            title.setText(listing.getName());
            description.setText(listing.getDescription());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, TabListingExpanded.class);
                    i.putExtra("listing", listing);
                    i.putExtra("isUserListing", isUserListing);
                    context.startActivity(i);
                }
            });
        }

        return convertView;
    }
}
