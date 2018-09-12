package com.example.srini.slugtutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.srini.slugtutor.Course;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = "MyActivity";
    ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new Parser().execute();
        Intent i = new Intent(this, EntryScreen.class);
        startActivity(i);
    }

}
