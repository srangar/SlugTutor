package com.example.srini.slugtutor;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class ListOfMajors extends AppCompatActivity {
    ListView lv;
    SearchView sv;
    Activity c;
    private static String URL = "https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/";
    private String[] arrayOfCourses = new String[75];


    private static ArrayList<Course> checkedItems = new ArrayList<Course>();
    private static ArrayList<Course> checkedItemsToDisplay = new ArrayList<Course>();
    private static ArrayList<Course> arr;
    Button submit;
    String submittedClasses = "";
    String submittedDisplay = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_majors);
        c = this;
        lv = (ListView) findViewById(R.id.majors);
        loadCourses();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListOfMajors.this,
                android.R.layout.simple_list_item_1, arrayOfCourses);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String type = arrayOfCourses[position ];
                String urltopass = URL + type.toLowerCase() + ".html";
                Intent i = new Intent(ListOfMajors.this, ListOfClasses.class);
                i.putExtra("type", type);
                i.putExtra("url", urltopass);
                startActivity(i);
            }


        });

    }

    public void loadCourses() {
        arrayOfCourses[0] = "ACEN";
        arrayOfCourses[1] = "ANTH";
        arrayOfCourses[2] = "APLX";
        arrayOfCourses[3] = "ANTH";
        arrayOfCourses[4] = "AMS";
        arrayOfCourses[5] = "ART";
        arrayOfCourses[6] = "ARTG";
        arrayOfCourses[7] = "ASTR";
        arrayOfCourses[8] = "BIOC";
        arrayOfCourses[9] = "BME";
        arrayOfCourses[10] = "CHEM";
        arrayOfCourses[11] = "CHIN";
        arrayOfCourses[12] = "CLST";
        arrayOfCourses[13] = "CLNI";
        arrayOfCourses[14] = "CLTE";
        arrayOfCourses[15] = "CMMU";
        arrayOfCourses[16] = "CMPM";
        arrayOfCourses[17] = "CMPE";
        arrayOfCourses[18] = "CMPS";
        arrayOfCourses[19] = "COWL";
        arrayOfCourses[20] = "CRES";
        arrayOfCourses[21] = "CRWN";
        arrayOfCourses[22] = "DANM";
        arrayOfCourses[23] = "EART";
        arrayOfCourses[24] = "EEB";
        arrayOfCourses[25] = "ECON";
        arrayOfCourses[26] = "EDUC";
        arrayOfCourses[27] = "EE";
        arrayOfCourses[28] = "ENVS";
        arrayOfCourses[29] = "FMST";
        arrayOfCourses[30] = "FILM";
        arrayOfCourses[31] = "FREN";
        arrayOfCourses[32] = "GAME";
        arrayOfCourses[33] = "GERM";
        arrayOfCourses[34] = "GREE";
        arrayOfCourses[35] = "HEBR";
        arrayOfCourses[36] = "HIS";
        arrayOfCourses[37] = "HAVC";
        arrayOfCourses[38] = "HISC";
        arrayOfCourses[39] = "ITAL";
        arrayOfCourses[40] = "JAPN";
        arrayOfCourses[41] = "JWST";
        arrayOfCourses[42] = "KRSG";
        arrayOfCourses[43] = "LAAD";
        arrayOfCourses[44] = "LATN";
        arrayOfCourses[45] = "LALS";
        arrayOfCourses[46] = "LGST";
        arrayOfCourses[47] = "LING";
        arrayOfCourses[48] = "MATH";
        arrayOfCourses[49] = "MERR";
        arrayOfCourses[50] = "METX";
        arrayOfCourses[51] = "MCDB";
        arrayOfCourses[52] = "MUSC";
        arrayOfCourses[53] = "OAKS";
        arrayOfCourses[54] = "OCEA";
        arrayOfCourses[55] = "PHIL";
        arrayOfCourses[56] = "PHYE";
        arrayOfCourses[57] = "POLI";
        arrayOfCourses[58] = "PRTR";
        arrayOfCourses[59] = "PORT";
        arrayOfCourses[60] = "PSYC";
        arrayOfCourses[61] = "PUNJ";
        arrayOfCourses[62] = "CRSN";
        arrayOfCourses[63] = "RUSS";
        arrayOfCourses[64] = "SCIC";
        arrayOfCourses[65] = "SOCD";
        arrayOfCourses[66] = "SOCY";
        arrayOfCourses[67] = "SPAN";
        arrayOfCourses[68] = "SPHS";
        arrayOfCourses[69] = "STEV";
        arrayOfCourses[70] = "TIM";
        arrayOfCourses[71] = "THEA";
        arrayOfCourses[72] = "UCDC";
        arrayOfCourses[73] = "WRIT";
        arrayOfCourses[74] = "YIDD";
    }
}
