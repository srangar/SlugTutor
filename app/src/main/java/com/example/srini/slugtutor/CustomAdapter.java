package com.example.srini.slugtutor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List listData;
    private LayoutInflater layoutInflater;
    private boolean clicked = false;

    public CustomAdapter(Context context, List<Listing> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_layout, null);
            holder = new ViewHolder();
            holder.headlineView = (TextView) convertView.findViewById(R.id.title);
            holder.reporterNameView = (TextView) convertView.findViewById(R.id.reporter);
            holder.reportedDateView = (TextView) convertView.findViewById(R.id.date);
            holder.claim = (Button)convertView.findViewById(R.id.button3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Listing l = (Listing) listData.get(position);
        holder.headlineView.setText(l.getName());
        holder.reporterNameView.setText(l.getId());

        holder.claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //claim listing
                clicked=!clicked;
                if(clicked) {
                    holder.claim.setBackgroundColor(Color.rgb(164, 198, 57));
                }
                else {
                    holder.claim.setBackgroundColor(Color.rgb(211, 211, 211));
                }
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView headlineView;
        TextView reporterNameView;
        TextView reportedDateView;
        Button claim;
    }


}
