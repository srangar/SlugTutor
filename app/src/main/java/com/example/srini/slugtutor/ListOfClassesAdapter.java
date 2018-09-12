package com.example.srini.slugtutor;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 4/17/2018.
 */

public class ListOfClassesAdapter extends ArrayAdapter<Course>  {
    private Activity context;
    private List<Course> items;

    public ListOfClassesAdapter(Activity context, List<Course> items) {
        super(context, R.layout.list_of_classes_cell, items);
        this.context = context;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_of_classes_cell, parent, false);
        }

        final TextView className = (TextView) convertView.findViewById(R.id.className);
        final TextView classTeacher = (TextView) convertView.findViewById(R.id.teacherName);
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        className.setText(items.get(position).getCourseNum());
        classTeacher.setText(items.get(position).getProfessor());
        checkBox.setOnCheckedChangeListener((ListOfClasses) context);
        return convertView;
    }

    public void setItems(List<Course> items) {
        this.items = items;
    }

}
