package com.gradeslate.gradeslate;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.gradeslate.gradeslate.backend.Courses;

import java.util.ArrayList;

public class CoursesList extends AppCompatActivity {
    FileSystem data;
    private FloatingActionButton fab;
    private EditText mSemester;
    private ArrayList<Courses> semesters;
    private ArrayList<String> semesterNames;
    private String semester;
    private ArrayAdapter<String> adapter;
    private EditText editText;
    private String empty = "please add a semester";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        data.getInstance();
        this.semesters = data.getSemesters();
        this.semesterNames = new ArrayList();
        semesterNames.add(empty);


        ListView listview = (ListView) findViewById(R.id.semesterNames);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.semester_item, semesterNames);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                semester = String.valueOf(parent.getItemAtPosition(position));
                Courses found = findSemester(semester);
                if(found != null) {
                    Toast.makeText(CoursesList.this,
                            found.getName(), Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CoursesList.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_semester, null);
                mSemester = (EditText) mView.findViewById(R.id.editSemester);
                Button mAdd = (Button) mView.findViewById(R.id.add);
                mAdd.setOnClickListener(new View.OnClickListener()  {
                    @Override
                    public void onClick(View view) {
                        if(!mSemester.getText().toString().isEmpty()){
                            // Toast.makeText(CoursesList.this,
                            //       R.string.semesterAddedMsg, Toast.LENGTH_SHORT).show();
                            semester = mSemester.getText().toString();
                            //semesterNames.add(semester);
                            Courses newSemester = new Courses(semester);
                            semesters.add(newSemester);
                            if(semesterNames.get(0)==empty) {
                                semesterNames.clear();
                                semesterNames.add(semester);
                            }
                            else{
                                semesterNames.add(semester);
                            }
                            adapter.notifyDataSetChanged();
                            String test = semesters.get(semesters.size()-1).getName();
                            Toast.makeText(CoursesList.this,
                                    test, Toast.LENGTH_SHORT).show();

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
    }//end of onFabClick

    public Courses findSemester(String name){
        for(int i = 0; i<semesters.size(); i++){
            if(semesters.get(i).getName()==name){
                return semesters.get(i);
            }
        }
        return null;
    }

}//end of class
