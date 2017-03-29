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
        String name = FileSystem.getInstance().getCourse().getProf().getName();
        Button profButton = (Button) findViewById(R.id.profButton);
        if ((name.replaceAll("\\s+","") != null) && (name.replaceAll("\\s+","") != "")) {
            profButton.setText(name);
        } else {
            profButton.setText("Professor");
        }
    }

    public void calcAverage(View view) {
        try {
          float grade = FileSystem.getInstance().getCourse().desGrd(Float.valueOf(((EditText) findViewById(R.id.calcAverage)).getText().toString()).floatValue());
            TextView result = (TextView) findViewById(R.id.seeVal);
            String res = String.valueOf(grade);
             if (grade > 100) {
                 res = "Futile";
             } else if (grade == 0) {
                  res = "Made It";
                }

            result.setText(res);
        }catch(Exception e){}
    }

    public void toGrades(View view) {
            Intent goToNextActivity = new Intent(view.getContext(), GradeList.class);
            startActivity(goToNextActivity);
        Intent intent = new Intent(this, GradeList.class);
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