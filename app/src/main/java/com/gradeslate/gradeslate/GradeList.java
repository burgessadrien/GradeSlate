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


import java.util.ArrayList;

public class GradeList extends AppCompatActivity {
    private FloatingActionButton fab;
    private EditText mGrade;
    private ArrayList<String> gradeNames;
    private String grade;
    private int perWorth = 0;
    private ArrayAdapter<String> adapter;
    private EditText worth;
    private String course;
    private String empty = "Please add a grade";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addNames();
        course = getIntent().getStringExtra("course");
        ListView listview = (ListView) findViewById(R.id.gradeNames);
        adapter = new ArrayAdapter<String>(this, R.layout.grade_item, R.id.grade_name, gradeNames);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                grade = String.valueOf(parent.getItemAtPosition(position));
                String found = findGrade(position);
                if(found != null) {
                    Toast.makeText(GradeList.this,
                            found, Toast.LENGTH_SHORT).show();
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
                final AlertDialog dialog = new AlertDialog.Builder(GradeList.this).create();
                View mView = getLayoutInflater().inflate(R.layout.dialog_grade, null);
                mGrade = (EditText) mView.findViewById(R.id.editGrade);
                worth = (EditText) mView.findViewById(R.id.enter_percent_worth);
                Button mAdd = (Button) mView.findViewById(R.id.add);
                mAdd.setOnClickListener(new View.OnClickListener()  {
                    @Override
                    public void onClick(View view) {
                        if(!mGrade.getText().toString().isEmpty()){
                            // Toast.makeText(courseList.this,
                            //       R.string.semesterAddedMsg, Toast.LENGTH_SHORT).show();
                            grade = mGrade.getText().toString();
                            perWorth = Integer.parseInt(worth.getText().toString());
                            FileSystem.getInstance().getGrades().addEval(grade, perWorth);
                            if(gradeNames.get(0)==empty) {
                                gradeNames.clear();
                                gradeNames.add(grade);
                            }
                            else{
                                gradeNames.add(grade);
                            }
                            adapter.notifyDataSetChanged();
                            String test = grade;
                            Toast.makeText(GradeList.this,
                                    test, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                        }
                        else{
                            Toast.makeText(GradeList.this,
                                    R.string.addGradeError, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.setView(mView);
                dialog.show();

            }
        });
    }//end of onFabClick


    public void courseInfo(View view){
        Intent goToNextActivity = new Intent(view.getContext(), course_info.class);
        FileSystem.getInstance().setCourse(course);
        startActivity(goToNextActivity);
    }


    public void addNames(){
        this.gradeNames = new ArrayList<String>();

        for(int i = 0; i < FileSystem.getInstance().getGrades().getEvaluations().size(); i++){
            this.gradeNames.add(FileSystem.getInstance().getGrades().getEvaluations().get(i).getType());
        }
        if(gradeNames.isEmpty()){
            gradeNames.add(empty);
        }
    }

    public String findGrade(int position){
        if(FileSystem.getInstance().getGrades().getEvaluations().get(position) != null){
            return FileSystem.getInstance().getGrades().getEvaluations().get(position).getType();
        }
        return null;
    }

}//end of class