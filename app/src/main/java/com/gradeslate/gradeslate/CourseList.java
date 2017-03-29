package com.gradeslate.gradeslate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.gradeslate.gradeslate.backend.FileSystem;

import java.util.ArrayList;

public class CourseList extends AppCompatActivity {
    private FloatingActionButton fab;
    private EditText mCourse;
    private ArrayList<String> courseNames;
    private String course;
    private String semester;
    private int credHour = 0;
    private ArrayAdapter<String> adapter;
    private EditText editCred;
    private String empty = "Please add a course";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addNames();
        semester = getIntent().getStringExtra("semester");


        ListView listview = (ListView) findViewById(R.id.courseNames);
        adapter = new ArrayAdapter<String>(this, R.layout.course_item, R.id.course_name, courseNames);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                try {
                    String found = null;
                        course = String.valueOf(parent.getItemAtPosition(position));
                        FileSystem.getInstance().setGrades(course);
                        FileSystem.getInstance().setCourse(course);
                        found = findCourse(position);

                    if (found != null) {
                        Toast.makeText(CourseList.this, course, Toast.LENGTH_SHORT).show();
                        Intent goToNextActivity = new Intent(view.getContext(), course_info.class);
                        goToNextActivity.putExtra("course", course);
                        startActivity(goToNextActivity);
                    }
                }catch(Exception e){
                    Toast.makeText(CourseList.this,
                            "Add Course", Toast.LENGTH_SHORT).show();
                }
            }
        });



        fab = (FloatingActionButton) findViewById(R.id.fab);
        onFabClick();
    }

    public void onFabClick(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog dialog = new AlertDialog.Builder(CourseList.this).create();
                View mView = getLayoutInflater().inflate(R.layout.dialog_course, null);
                mCourse = (EditText) mView.findViewById(R.id.editCourse);
                editCred = (EditText) mView.findViewById(R.id.enter_cred_hour);
                Button mAdd = (Button) mView.findViewById(R.id.add);
                mAdd.setOnClickListener(new View.OnClickListener()  {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (!mCourse.getText().toString().isEmpty()) {
                                course = mCourse.getText().toString();
                                credHour = Integer.parseInt(editCred.getText().toString());
                                if ((credHour < 0) | (credHour > 5)) {
                                    dialog.dismiss();
                                }

                                FileSystem.getInstance().addCourse(course, credHour);
                                if (courseNames.get(0) == empty) {
                                    courseNames.clear();
                                    courseNames.add(course);
                                } else {
                                    courseNames.add(course);
                                }
                                adapter.notifyDataSetChanged();
                                String test = course;
                                Toast.makeText(CourseList.this,
                                        test, Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                            } else {
                                Toast.makeText(CourseList.this,
                                        R.string.addCourseError, Toast.LENGTH_SHORT).show();
                            }
                        }catch(Exception e){}
                    }
                });
                dialog.setView(mView);
                dialog.show();

            }
        });
    }//end of onFabClick



    public void addNames(){
        this.courseNames = new ArrayList<String>();

        for(int i = 0; i < FileSystem.getInstance().getCourses().size(); i++){
            this.courseNames.add(FileSystem.getInstance().getCourses().get(i).getTitle());
        }
        if(courseNames.isEmpty()){
            courseNames.add(empty);
        }
    }

    public String findCourse(int position){
        if(FileSystem.getInstance().getCourses().get(position) != null){
            return FileSystem.getInstance().getCourses().get(position).getTitle();
        }
        return null;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        FileSystem.getInstance().writeSemesters(this);
    }

}//end of class