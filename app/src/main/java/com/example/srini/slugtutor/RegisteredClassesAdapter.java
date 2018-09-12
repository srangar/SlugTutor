package com.example.srini.slugtutor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 4/17/2018.
 */

public class RegisteredClassesAdapter extends ArrayAdapter<Course>  {
    private Activity context;
    private List<Course> items;

    public RegisteredClassesAdapter(Activity context, List<Course> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_classes, parent, false);
        }

        final Course course = items.get(position);

        TextView className = convertView.findViewById(R.id.className);
        TextView classTeacher = convertView.findViewById(R.id.teacherName);

        if (course != null) {
            className.setText(course.getCourseNum());
            classTeacher.setText(course.getProfessor());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, TabGroupActivity.class);
                    System.out.println(course);
                    i.putExtra("classData", course);
                    i.putExtra("isUser", "false");
                    context.startActivity(i);
                }
            });
        }

        return convertView;
    }

}
