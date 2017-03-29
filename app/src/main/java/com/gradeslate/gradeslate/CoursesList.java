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
import com.gradeslate.gradeslate.backend.Courses;
import com.gradeslate.gradeslate.backend.FileSystem;

import java.util.ArrayList;


public class CoursesList extends AppCompatActivity {

    private FloatingActionButton fab;
    private EditText mSemester;
    private ArrayList<String> semesterNames;
    private String semester;
    private ArrayAdapter<String> adapter;
    private EditText editText;
    private String empty = "Please add a semester";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addNames();


        ListView listview = (ListView) findViewById(R.id.semesterNames);
        adapter = new ArrayAdapter<String>(this, R.layout.semester_item, R.id.semester_name, semesterNames);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                try {
                semester = findSemester(position);
                    FileSystem.getInstance().setCourses(semester);
                    if (semester != null) {
                        Toast.makeText(CoursesList.this,
                                semester, Toast.LENGTH_SHORT).show();
                        Intent goToNextActivity = new Intent(view.getContext(), CourseList.class);
                        goToNextActivity.putExtra("semester", semester);
                        startActivity(goToNextActivity);
                    }
                }catch(Exception e){
                    Toast.makeText(CoursesList.this,
                            "Add Semester", Toast.LENGTH_SHORT).show();
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
                final AlertDialog dialog = new AlertDialog.Builder(CoursesList.this).create();
                View mView = getLayoutInflater().inflate(R.layout.dialog_semester, null);

                mSemester = (EditText) mView.findViewById(R.id.editSemester);
                Button mAdd = (Button) mView.findViewById(R.id.add);
                mAdd.setOnClickListener(new View.OnClickListener()  {
                    @Override
                    public void onClick( View view) {
                        if(!mSemester.getText().toString().isEmpty()){
                            semester = mSemester.getText().toString();
                            Courses newSemester = new Courses(semester);
                            FileSystem.getInstance().addSemester(semester);
                            if(semesterNames.get(0)==empty) {
                                semesterNames.clear();
                                semesterNames.add(semester);
                            }
                            else{
                                semesterNames.add(semester);
                            }
                            adapter.notifyDataSetChanged();
                            String test = FileSystem.getInstance().getSemesters().get(FileSystem.getInstance().getSemesters().size()-1).getName();
                            Toast.makeText(CoursesList.this,
                                    test, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                        }
                        else{
                            Toast.makeText(CoursesList.this,
                                    R.string.errorSemesterMsg, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.setView(mView);
                dialog.show();

            }
        });
    }//end of onFabClick

    public String findSemester(int position){
        if(FileSystem.getInstance().getSemesters().get(position) != null){
            return FileSystem.getInstance().getSemesters().get(position).getName();
        }
        return null;
    }

    public void addNames(){
        this.semesterNames = new ArrayList<String>();

        for(int i = 0; i < FileSystem.getInstance().getSemesters().size(); i++){
            this.semesterNames.add(FileSystem.getInstance().getSemesters().get(i).getName());
        }
        if(semesterNames.isEmpty()){
            semesterNames.add(empty);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        FileSystem.getInstance().writeSemesters(this);
    }

}//end of class
