package com.example.rohan.f7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohan.f7.Fragments.Fri;
import com.example.rohan.f7.Fragments.Mon;
import com.example.rohan.f7.Fragments.Sat;
import com.example.rohan.f7.Fragments.Thu;
import com.example.rohan.f7.Fragments.Tue;
import com.example.rohan.f7.Fragments.Wed;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    String[] type={
            "LEC",
            "TUTE",
            "TUTE",
            "TUTE",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LAB"
    };
    String[] subject={
           "COMPUTER NETWORKS",
            "Technology and Culture",
            "PLANNING AND ECONOMIC DEVELOPMENT",
            "PRINCIPLES OF MANAGEMENT",
            "Materials Science",
            "Laser Technology and Applications",
            "COMPUTER BASED NUMERICAL TECHNIQUES",
            "STATISTICAL INFORMATION THEORY WITH APPLICATIONS",
            "DECISION MAKING USING MATHEMATICAL AND STATISTICAL APPROACH",
            "Matrix Computations",
            "LOGICAL REASONING AND INEQUALITIES",
            "Quantum Mechanics for Engineers",
            "Sociology of Youth",
            "PLANNING AND ECONOMIC DEVELOPMENT",
            "Technology and Culture",
            "Strategic Human Resource Management",
            "PRINCIPLES OF MANAGEMENT",
            "SOFTWARE ENGINEERING LAB"

    };
    String[] value={
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE"

    };
    String[] faculty={
            "RUPESH",
            "RG",
            "AA",
            "DV",
            "SD",
            "AV",
            "PKS",
            "PINKEY",
            "AMS",
            "AMITA",
            "NEHA",
            "VM",
            "ALKA",
            "AA",
            "RG",
            "PRV",
            "DV",
            "SHRUTI/NITIN/SANDHYA"

    };
    String[] timing={
            "9:00-9:50",
            "9:55-10:45",
            "9:55-10:45",
            "9:55-10:45",
            "10:50-11:40",
            "10:50-11:40",
            "10:50-11:40",
            "10:50-11:40",
            "10:50-11:40",
            "10:50-11:40",
            "10:50-11:40",
            "10:50-11:40",
            "11:45-12:35",
            "11:45-12:35",
            "11:45-12:35",
            "11:45-12:35",
            "12:40-1:30",
            "1:35-3:20"
          };
    String[] venue={
            "228",
            "127",
            "126",
            "121",
            "118(A)",
            "118(B)",
            "244(A)",
            "244(B)",
            "111",
            "217",
            "226",
            "228",
            "111",
            "217",
            "226",
            "228",
            "111",
            "35"
    };

    String[] batch={
            "F7F8"

    };

    String[] type2={
            "LAB",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "TUTE",
            "TUTE",
            "TUTE",
            "TUTE",
            "TUTE",
            "TUTE",
            "TUTE"
    };
    String[] subject2={
            "Open Source Software Lab",
            "COMPUTER NETWORKS",
            "Sociology of Youth",
            "PLANNING AND ECONOMIC DEVELOPMENT",
            "Technology and Culture",
            "SOFTWARE ENGINEERING",
            "ARTIFICIAL INTELLIGENCE",
            "MATERIALS SCIENCE",
            "Laser Technology and Applications",
            "COMPUTER BASED NUMERICAL TECHNIQUES",
            "STATISTICAL INFORMATION THEORY WITH APPLICATIONS",
            "DECISION MAKING USING MATHEMATICAL AND STATISTICAL APPROACH",
            "Matrix Computations",
            "LOGICAL REASONING AND INEQUALITIES",
            "Quantum Mechanics for Engineers",
            "Quantum Mechanics for Engineers",
            "Materials Science",
            "Laser Technology and Applications",
            "COMPUTER BASED NUMERICAL TECHNIQUES",
            "STATISTICAL INFORMATION THEORY WITH APPLICATIONS",
            "DECISION MAKING USING MATHEMATICAL AND STATISTICAL APPROACH",
            "Strategic Human Resource Management"
    };
    String [] value2={
            "CORE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE"

    };
    String [] faculty2={
            "HM/RUPESH/AMRIT",
            "RUPESH",
            "ALKA",
            "AA",
            "RG",
            "NITIN",
            "AM",
            "SD",
            "AV",
            "PKS",
            "PINKEY",
            "AMS",
            "AMITA",
            "NEHA",
            "VM",
            "VM",
            "SD",
            "AV",
            "PKS",
            "PINKEY",
            "PRIYA",
            "RG"
    };
    String [] timing2={
            "9:00-10:45",
            "10:50-11:40",
            "11:45-12:35",
            "11:45-12:35",
            "11:45-12:35",
            "12:40-1:30",
            "12:40-1:30",
            "1:35-2:25",
            "1:35-2:25",
            "1:35-2:25",
            "1:35-2:25",
            "1:35-2:25",
            "1:35-2:25",
            "1:35-2:25",
            "1:35-2:25",
            "2:30-3:20",
            "2:30-3:20",
            "2:30-3:20",
            "2:30-3:20",
            "2:30-3:20",
            "2:30-3:20",
            "3:25-4:15"
    };
    String [] venue2={
            "35",
            "111",
            "244(A)",
            "226",
            "226",
            "226",
            "118(B)",
            "217",
            "226",
            "228",
            "111",
            "118(A)",
            "123",
            "137",
            "244(A)",
            "244(A)",
            "244(B)",
            "118(A)",
            "228",
            "111",
            "113",
            "123"
    };
    String[] batch2={
            "F7F8"

    };

    String [] type3={
            "LAB",
            "TUTE",
            "TUTE",
            "TUTE",
            "LAB",
            "TUTE",
            "LAB"
    };
    String [] subject3={
            "Information Security Lab",
            "SOFTWARE ENGINEERING",
            "Matrix Computations",
            "LOGICAL REASONING AND INEQUALITIES",
            "COMPUTER NETWORKS LAB",
            "COMPUTER NETWORKS",
            "Information Security Lab"
    };
    String [] value3={
            "CORE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "CORE"

};

    String [] faculty3={
            "KM",
            "AMRIT PAL",
            "AMITA",
            "NEHA",
            "BDJ/SB/NEERAJ",
            "RUPESH",
            "NITIN"
    };
    String [] timing3={
            "9:00-10:45",
            "10:50-11:40",
            "11:45-12:35",
            "11:45-12:35",
            "1:35-3:20",
            "3:25-4:15",
            "3:25-5:10"
    };
    String [] venue3={
            "MML",
            "225",
            "121",
            "226",
            "151",
            "229",
            "MML"
    };

    String[] batch3={
            "F7",
            "F8",
            "F7F8",
            "F7F8",
            "F7F8",
            "F7",
            "F8"
    };
    String [] type4={
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "LEC",
            "TUTE",
            "TUTE",
            "TUTE",
            "LAB"
    };
    String [] subject4={
            "Strategic Human Resource Management",
            "Materials Science",
            "Laser Technology and Applications",
            "COMPUTER BASED NUMERICAL TECHNIQUES",
            "STATISTICAL INFORMATION THEORY WITH APPLICATIONS",
            "DECISION MAKING USING MATHEMATICAL AND STATISTICAL APPROACH",
            "Matrix Computations",
            "LOGICAL REASONING AND INEQUALITIES",
            "Quantum Mechanics for Engineers",
            "SOFTWARE ENGINEERING",
            "ARTIFICIAL INTELLIGENCE",
            "Sociology of Youth",
            "SOFTWARE ENGINEERING",
            "ARTIFICIAL INTELLIGENCE",
            "ARTIFICIAL INTELLIGENCE LAB"
    };
    String [] value4={
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE"

    };
    String [] faculty4={
            "RG",
            "SD",
            "AV",
            "PKS",
            "PINKEY",
            "AMS",
            "AMITA",
            "NEHA",
            "VM",
            "NITIN",
            "AM",
            "ALKA",
            "NITIN",
            "AM",
            "AM/KAJOL"
    };
    String [] timing4={
            "9:00-9:50",
            "9:55-10:45",
            "9:55-10:45",
            "9:55-10:45",
            "9:55-10:45",
            "9:55-10:45",
            "9:55-10:45",
            "9:55-10:45",
            "9:55-10:45",
            "10:50-11:40",
            "10:50-11:40",
            "12:40-1:30",
            "1:35-2:25",
            "1:35-2:25",
            "3:25-5:10"
    };
    String [] venue4={
            "153",
            "217",
            "226",
            "228",
            "111",
            "244(A)",
            "244(B)",
            "118(A)",
            "148",
            "228",
            "118(A)",
            "116",
            "126",
            "113",
            "151"
    };
    String[] batch4={
            "F7F8",
            "F8F8",
            "F7F8",
            "F7F8",
            "F7F8",
            "F8F8",
            "F7F8",
            "F7F8",
            "F7F8",
            "F7F8",
            "F7F8",
            "F7F8",
            "F7",
            "F7F8",
            "F7F8"

    };
    String [] type5={
            "LEC",
            "LEC",
            "TUTE",
            "LEC",
            "LEC"
    };
    String [] subject5={
            "ARTIFICIAL INTELLIGENCE",
            "SOFTWARE ENGINEERING",
            "COMPUTER NETWORKS",
            "COMPUTER NETWORKS",
            "PRINCIPLES OF MANAGEMENT"
    };
    String [] value5={
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE",
            "ELECTIVE"
    };

    String [] faculty5={
            "AM",
            "NITIN",
            "RUPESH",
            "RUPESH",
            "DV"
    };
    String [] timing5={
            "9:00-9:50",
            "9:00-9:50",
            "9:55-10:45",
            "10:50-11:40",
            "1:35-2:25"
    };
    String [] venue5={
            "228",
            "118(B)",
            "127",
            "226",
            "217"
    };
    String[] batch5={
            "F7F8",
            "F7F8",
            "F8",
            "F7F8",
            "F7F8"

    };

    ArrayList<ArrayList<SubjectDetails>> subjectDetailsArrayList= new ArrayList<>();
    DatabaseReference databaseReference;


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        Calendar c = Calendar.getInstance();
        int dayofweek = c.get(Calendar.DAY_OF_WEEK);
        if(dayofweek==1 || dayofweek==2)
        {
            mViewPager.setCurrentItem(0,true);
        }
        else{
            mViewPager.setCurrentItem(dayofweek-2,true);
        }
//      setTimeTableToDataBase();


        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.keepSynced(true);


        final TinyDB tinyDB= new TinyDB(this);
        databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    GenericTypeIndicator<ArrayList<ArrayList<SubjectDetails>>> t = new GenericTypeIndicator<ArrayList<ArrayList<SubjectDetails>>>() {
                    };

                    if (tinyDB.getSubjectDetails("SEMESTER_5")==null)
                    {
                        tinyDB.putSubjectDetails("SEMESTER_5",dataSnapshot.child("SEMESTER_5").getValue(t));

                    }else if ((tinyDB.getSubjectDetails("SEMESTER_5")!=dataSnapshot.child("SEMESTER_5").getValue(t))){
                        tinyDB.putSubjectDetails("SEMESTER_5",dataSnapshot.child("SEMESTER_5").getValue(t));

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {


                }
            });


        if (tinyDB.getSubjectDetails("SEMESTER_5")!=null)
        {
            //Toast.makeText(this, ""+tinyDB.getSubjectDetails("SEMESTER_5").get(0).get(0).getSubjectName(), Toast.LENGTH_SHORT).show();
        }

        if (tinyDB.getChoices("ELECTIVES")==null){
            Toast.makeText(this, "CHOOSE ELECTIVES", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, ChooseElective.class));
            finish();

        }


    }

    private void setTimeTableToDataBase() {
        ArrayList<SubjectDetails> MONDAY = new ArrayList<>();
        for (int i=0;i<subject.length;i++)
        {
            SubjectDetails subjectDetails = new SubjectDetails(
                    type[i],
                    subject[i],
                    timing[i],
                    faculty[i],
                    venue[i],
                    value[i],
                    batch[0]);
            MONDAY.add(subjectDetails);
        }
        ArrayList<SubjectDetails> TUESDAY = new ArrayList<>();
        for (int i=0;i<subject2.length;i++)
        {
            SubjectDetails subjectDetails = new SubjectDetails(
                    type2[i],
                    subject2[i],
                    timing2[i],
                    faculty2[i],
                    venue2[i],
                    value2[i],
                    batch2[0]);
            TUESDAY.add(subjectDetails);
        }
        ArrayList<SubjectDetails> WEDNESDAY = new ArrayList<>();
        for (int i=0;i<subject3.length;i++)
        {
            SubjectDetails subjectDetails = new SubjectDetails(
                    type3[i],
                    subject3[i],
                    timing3[i],
                    faculty3[i],
                    venue3[i],
                    value3[i],
                    batch3[i]);
            WEDNESDAY.add(subjectDetails);
        }
        ArrayList<SubjectDetails> THURSDAY = new ArrayList<>();
        for (int i=0;i<subject4.length;i++)
        {
            SubjectDetails subjectDetails = new SubjectDetails(
                    type4[i],
                    subject4[i],
                    timing4[i],
                    faculty4[i],
                    venue4[i],
                    value4[i],
                    batch4[i]);
            THURSDAY.add(subjectDetails);
        }
        ArrayList<SubjectDetails> FRIDAY = new ArrayList<>();
        for (int i=0;i<subject5.length;i++)
        {
            SubjectDetails subjectDetails = new SubjectDetails(
                    type5[i],
                    subject5[i],
                    timing5[i],
                    faculty5[i],
                    venue5[i],
                    value5[i],
                    batch5[i]);
            FRIDAY.add(subjectDetails);
        }
        ArrayList<SubjectDetails> SATURDAY = new ArrayList<>();

        subjectDetailsArrayList.add(MONDAY);
        subjectDetailsArrayList.add(TUESDAY);
        subjectDetailsArrayList.add(WEDNESDAY);
        subjectDetailsArrayList.add(THURSDAY);
        subjectDetailsArrayList.add(FRIDAY);
        subjectDetailsArrayList.add(SATURDAY);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("SEMESTER_5").setValue(subjectDetailsArrayList);
        databaseReference.keepSynced(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {

            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse("https://webkiosk.jiit.ac.in/"));


        }
        if (id==R.id.changeElective){
           startActivity(new Intent(MainActivity.this, ChooseElective.class));
           finish();
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0)
            {
                Mon t1= new Mon();
                return t1;
            }
            else if (position==1)
            {
                Tue t2= new Tue();
                return t2;
            }
            else if (position==2)
            {
                Wed t3= new Wed();
                return t3;
            }
            else if (position==3)
            {
                Thu t4= new Thu();
                return t4;
            }
            else if (position==4)
            {
                Fri t5= new Fri();
                return t5;
            }
            else if (position==5)
            {
                Sat t6= new Sat();
                return t6;
            }

            return null;
        }

        @Override
        public int getCount() {

            return 6;
        }
    }
    void swapSubjects()
    {
        for(int i=0; i<faculty.length;i++)
        {
            if (faculty[i].equals("Pinkey"))
            {
                for (int j=0;j<faculty.length;j++)
                {
                    if (faculty[j].equals("Amita"))
                    {
                        String temp = subject[j];
                        subject[j]= subject[i];
                        subject[i]= temp;
                    }
                }
            }
        }
    }
}
