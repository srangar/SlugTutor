package com.example.srini.slugtutor;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Srini
 */

public class NewParser extends AsyncTask<String, List<Course>, List<Course>> {

    private ListView listView;
    private Context context;
    private List<Course> courses;

    public NewParser(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected List<Course> doInBackground(String... params) {
        return loadList(params[0]);
    }

    @Override
    protected void onPostExecute(List<Course> result) {
        final ListOfClassesAdapter classesDisplay = new ListOfClassesAdapter((Activity)context, result);
        listView.setAdapter(classesDisplay);
    }

    private List<Course> loadList(String type) {

        courses = new ArrayList<>();

        try {
            Document document = Jsoup
                    .connect("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/" + type + ".html")
                    .get();
            Elements data = document.select("p");

            String names = data.toString();


            String[] nameArray = names.split("\n");

            List<String> temp = new ArrayList<>();
            for (String s : nameArray) {
                if (s.contains("<p><strong>")) {
                    s = s.replace("<p>", "");
                    s = s.replace("<strong>", "");
                    s = s.replace("</p>", "");
                    s = s.replace("</strong>", "");
                    s = s.replace("<em>", "");
                    s = s.replace("</em>", "");
                    s = s.replace("<br>", "");
                    temp.add(s);
                }
            }

            for (String s : temp) {
                String[] t = s.split("\\.");
                if (!t[2].contains("notoffered")) {
                    courses.add(new Course(type.toUpperCase()+" "+ t[0], t[t.length - 1]+" ".toUpperCase(), t[1]));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }


    public List<Course> getCourses() {
        return courses;
    }
}
