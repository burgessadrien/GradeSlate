package com.gradeslate.gradeslate;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gradeslate.gradeslate.backend.FileSystem;

public class course_info extends AppCompatActivity {
    private String course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        course = getIntent().getStringExtra("course");
        TextView courseName = (TextView) findViewById(R.id.displayCourseName);
        courseName.setText(course);
        double average = Math.round(FileSystem.getInstance().getCourse().getGrades().getAvgGrds()*100.0)/100.0;
        String disAverage = String.valueOf(average);
        double current = Math.round(FileSystem.getInstance().getCourse().getGrades().getCurGrd()*100.0)/100.0;
        String disCurrent = String.valueOf(current);
        char letter = FileSystem.getInstance().getCourse().getGrades().getLetGrd();
        TextView displayAverage = (TextView) findViewById(R.id.displayAverage);
        displayAverage.setText(disAverage);
        TextView displayLetter = (TextView) findViewById(R.id.displayLetter);
        displayLetter.setText(String.valueOf(letter));
        TextView displayCurrent = (TextView) findViewById(R.id.displayCurrent);
        displayCurrent.setText(disCurrent);

    }

    public void calcAverage(View view) {
        try {
          float grade = FileSystem.getInstance().getCourse().desGrd(Float.valueOf(((EditText) findViewById(R.id.calcAverage)).getText().toString()).floatValue());
            TextView result = (TextView) findViewById(R.id.seeVal);
            String res = "";
             if (grade > 100) {
                 res = "Futile";
             } else if (grade == 0) {
                  res = "Made It";
                }
                else if((grade>0)&&(grade<100)){
                 res = String.valueOf(grade);
             }
                else{
                 res = "Futile";
             }

            result.setText(res);
        }catch(Exception e){}
    }

    public void toGrades(View view) {
        Intent intent = new Intent(this, GradeList.class);
        startActivity(intent);
    }

    public void toSupplies(View view) {
        Intent intent = new Intent(this, Supplies.class);
        startActivity(intent);
    }

    public void toProf(View view){
        Intent goToNextActivity = new Intent(view.getContext(), ProfInfo.class);
        FileSystem.getInstance().setCourse(course);
        startActivity(goToNextActivity);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        FileSystem.getInstance().writeSemesters(this);
    }

}//end of class