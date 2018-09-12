package com.example.srini.slugtutor;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Srini 
 */

@SuppressLint("NewApi")
public class Parser extends AsyncTask<Void,Void, Void> {
    private static final String TAG = "TAG";
    public static ArrayList<Course> cmps=new ArrayList<Course>();
    public static ArrayList<Course> acen=new ArrayList<Course>();
    public static ArrayList<Course> anth=new ArrayList<Course>();
    public static ArrayList<Course> aplx=new ArrayList<Course>();
    public static ArrayList<Course> ams=new ArrayList<Course>();
    public static ArrayList<Course> art=new ArrayList<Course>();
    public static ArrayList<Course> artg=new ArrayList<Course>();
    public static ArrayList<Course> astr=new ArrayList<Course>();
    public static ArrayList<Course> bme=new ArrayList<Course>();
    public static ArrayList<Course> bioc=new ArrayList<Course>();
    public static ArrayList<Course> chem=new ArrayList<Course>();
    public static ArrayList<Course> chin=new ArrayList<Course>();
    public static ArrayList<Course> clst=new ArrayList<Course>();
    public static ArrayList<Course> clni=new ArrayList<Course>();
    public static ArrayList<Course> clte=new ArrayList<Course>();
    public static ArrayList<Course> cmmu=new ArrayList<Course>();
    public static ArrayList<Course> cmpm=new ArrayList<Course>();
    public static ArrayList<Course> cmpe=new ArrayList<Course>();
    public static ArrayList<Course> cowl=new ArrayList<Course>();
    public static ArrayList<Course> cres=new ArrayList<Course>();
    public static ArrayList<Course> crwn=new ArrayList<Course>();
    public static ArrayList<Course> danm=new ArrayList<Course>();
    public static ArrayList<Course> eart=new ArrayList<Course>();
    public static ArrayList<Course> eeb=new ArrayList<Course>();
    public static ArrayList<Course> econ=new ArrayList<Course>();
    public static ArrayList<Course> educ=new ArrayList<Course>();
    public static ArrayList<Course> ee=new ArrayList<Course>();
    public static ArrayList<Course> envs=new ArrayList<Course>();
    public static ArrayList<Course> fmst=new ArrayList<Course>();
    public static ArrayList<Course> film=new ArrayList<Course>();
    public static ArrayList<Course> fren=new ArrayList<Course>();
    public static ArrayList<Course> game=new ArrayList<Course>();
    public static ArrayList<Course> germ=new ArrayList<Course>();
    public static ArrayList<Course> gree=new ArrayList<Course>();
    public static ArrayList<Course> hebr=new ArrayList<Course>();
    public static ArrayList<Course> his=new ArrayList<Course>();
    public static ArrayList<Course> havc=new ArrayList<Course>();
    public static ArrayList<Course> hisc=new ArrayList<Course>();
    public static ArrayList<Course> ital=new ArrayList<Course>();
    public static ArrayList<Course> japn=new ArrayList<Course>();
    public static ArrayList<Course> jwst=new ArrayList<Course>();
    public static ArrayList<Course> laad=new ArrayList<Course>();
    public static ArrayList<Course> krsg=new ArrayList<Course>();
    public static ArrayList<Course> lals=new ArrayList<Course>();
    public static ArrayList<Course> latn=new ArrayList<Course>();
    public static ArrayList<Course> ling=new ArrayList<Course>();
    public static ArrayList<Course> lgst=new ArrayList<Course>();
    public static ArrayList<Course> math=new ArrayList<Course>();
    public static ArrayList<Course> merr=new ArrayList<Course>();
    public static ArrayList<Course> mcdb=new ArrayList<Course>();
    public static ArrayList<Course> metx=new ArrayList<Course>();
    public static ArrayList<Course> musc=new ArrayList<Course>();
    public static ArrayList<Course> oaks=new ArrayList<Course>();
    public static ArrayList<Course> ocea=new ArrayList<Course>();
    public static ArrayList<Course> phil=new ArrayList<Course>();
    public static ArrayList<Course> phye=new ArrayList<Course>();
    public static ArrayList<Course> phys=new ArrayList<Course>();
    public static ArrayList<Course> poli=new ArrayList<Course>();
    public static ArrayList<Course> prtr=new ArrayList<Course>();
    public static ArrayList<Course> port=new ArrayList<Course>();
    public static ArrayList<Course> psyc=new ArrayList<Course>();
    public static ArrayList<Course> punj=new ArrayList<Course>();
    public static ArrayList<Course> russ=new ArrayList<Course>();
    public static ArrayList<Course> crsn=new ArrayList<Course>();
    public static ArrayList<Course> scic=new ArrayList<Course>();
    public static ArrayList<Course> socd=new ArrayList<Course>();
    public static ArrayList<Course> socy=new ArrayList<Course>();
    public static ArrayList<Course> span=new ArrayList<Course>();
    public static ArrayList<Course> sphs=new ArrayList<Course>();
    public static ArrayList<Course> stev=new ArrayList<Course>();
    public static ArrayList<Course> tim=new ArrayList<Course>();
    public static ArrayList<Course> thea=new ArrayList<Course>();
    public static ArrayList<Course> ucdc=new ArrayList<Course>();
    public static ArrayList<Course> writ=new ArrayList<Course>();
    public static ArrayList<Course> yidd=new ArrayList<Course>();

    public static ArrayList<Course> test=new ArrayList<Course>();

    public static ArrayList<Course> courses=new ArrayList<Course>();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    public static ArrayList<Course> getCoursesArr(){
        ArrayList<Course> duplicate = new ArrayList<Course>();
        for(int i = 0;i<courses.size();i++)
        {
            if(!courses.get(i).equals(null) && !courses.get(i).getProfessor().toLowerCase().trim().equals("not offered"))
            {
                duplicate.add(courses.get(i));
            }
        }
        Collections.sort(duplicate, new Comparator<Course>() {
            @Override
            public int compare(Course u1, Course u2) {
                return u1.getCourseNum().compareToIgnoreCase(u2.getCourseNum());
            }
        });
        return duplicate;
    }
    @Override
    protected Void doInBackground(Void... params) {
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/cmps.html",cmps, "CMPS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/acen.html",acen, "ACEN");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/anth.html",anth, "ANTH");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/aplx.html",aplx,"APLX");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/ams.html",ams,"AMS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/art.html",art,"ART");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/artg.html",artg,"ARTG");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/astr.html",astr,"ASTR");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/bioc.html",bioc,"BIOC");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/bme.html",bme,"BME");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/chem.html",chem, "CHEM");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/chin.html",chin,"CHIN");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/clst.html",clst,"CLST");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/clni.html",clni,"CLNI");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/clte.html",clte,"CLTE");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/cmmu.html",cmmu,"CMMU");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/cmpm.html",cmpm,"CMPM");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/cmpe.html",cmpe,"CMPE");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/cowl.html",cowl,"COWL");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/cres.html",cres,"CRES");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/crwn.html",crwn,"CRWN");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/danm.html",danm,"DANM");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/eart.html",eart,"EART");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/eeb.html",eeb,"EEB");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/econ.html",econ,"ECON");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/educ.html",educ,"EDUC");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/ee.html",ee,"EE");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/envs.html",envs,"ENVS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/fmst.html",fmst,"FMST");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/film.html",film,"FILM");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/fren.html",fren,"FREN");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/game.html",game,"GAME");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/germ.html",germ,"GERM");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/gree.html",gree,"GREE");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/hebr.html",hebr,"HEBR");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/his.html",his,"HIS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/havc.html",havc,"HAVC");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/hisc.html",hisc,"HISC");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/ital.html",ital,"ITAL");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/japn.html",japn,"JAPN");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/jwst.html",jwst,"JWST");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/krsg.html",krsg,"KRSG");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/laad.html",laad,"LAAD");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/latn.html",latn,"LATN");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/lals.html",lals,"LALS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/lgst.html",lgst,"LGST");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/ling.html",ling,"LING");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/math.html",math,"MATH");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/merr.html",merr,"MERR");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/metx.html",metx,"METX");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/mcdb.html",mcdb,"MCDB");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/musc.html",musc,"MUSC");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/oaks.html",oaks,"OAKS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/ocea.html",ocea,"OCEA");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/phil.html",phil,"PHIL");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/phye.html",phye,"PHYE");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/phys.html",phys,"PHYS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/poli.html",poli,"POLI");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/prtr.html",prtr,"PRTR");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/port.html",port,"PORT");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/psyc.html",psyc,"PSYC");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/punj.html",punj,"PUNJ");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/crsn.html",crsn,"CRSN");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/russ.html",russ,"RUSS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/scic.html",scic,"SCIC");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/socd.html",socd,"SOCD");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/socy.html",socy,"SOCY");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/span.html",span,"SPAN");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/sphs.html",sphs,"SPHS");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/stev.html",stev,"STEV");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/tim.html",tim,"TIM");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/thea.html",thea,"THEA");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/ucdc.html",ucdc,"UCDC");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/writ.html",writ,"WRIT");
        loadList("https://registrar.ucsc.edu/catalog/programs-courses/course-descriptions/yidd.html",yidd,"YIDD");
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {

    }

    public static ArrayList<Course> loadList(String url, ArrayList<Course> list, String name)
    {
        try {
            Document document = Jsoup.connect(url).get();
            Elements data = document.select("p");

            String names = data.toString();


            String[] nameArray = names.split("\n");

            ArrayList<String> temp = new ArrayList<String>();
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
                if (t[2].contains("notoffered")) {
                    list.add(new Course(name+" "+ t[0], "NOT OFFERED", "NOT OFFERED"));
                    courses.add(new Course(name+" "+ t[0], "NOT OFFERED", "NOT OFFERED"));
                } else {
                    list.add(new Course(name+" "+ t[0], t[t.length - 1]+" ".toUpperCase(), t[1]));
                    courses.add(new Course(name+" "+ t[0], t[t.length - 1]+" ".toUpperCase(), t[1]));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    return list;
    }


}
