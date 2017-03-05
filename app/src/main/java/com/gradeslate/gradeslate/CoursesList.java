package com.gradeslate.gradeslate;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CoursesList extends AppCompatActivity {
    private ArrayList<Courses> semesters;
    private String semester;
    private ArrayList<String> semesterNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.semesters = new ArrayList();
        this.semesterNames = new ArrayList();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CoursesList.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_semester, null);
                final EditText mSemester = (EditText) mView.findViewById(R.id.editSemester);
                Button mAdd = (Button) mView.findViewById(R.id.add);
                mAdd.setOnClickListener(new View.OnClickListener()  {
                    @Override
                    public void onClick(View view) {
                        if(!mSemester.getText().toString().isEmpty()){
                            Toast.makeText(CoursesList.this,
                                    R.string.semesterAddedMsg, Toast.LENGTH_SHORT).show();
                            semester = mSemester.getText().toString();
                            semesterNames.add(semester);
                            Courses newSemester = new Courses(semester);
                            semesters.add(newSemester);
                        }
                        else{
                            Toast.makeText(CoursesList.this,
                                    R.string.errorSemesterMsg, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }



        });
        ListAdapter semestersAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, semesterNames);
        ListView semestersView = (ListView) findViewById(R.id.semestersView);
        semestersView.setAdapter(semestersAdapter);

        semestersView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        String semester = semesterNames.get(position);
                    }
                }
        );

    }//end of onCreate()

    public View onCreateiew(LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.activity_courses_list, container, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
    }

}//end of class

