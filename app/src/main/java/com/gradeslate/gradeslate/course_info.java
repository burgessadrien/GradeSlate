package com.gradeslate.gradeslate;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.gradeslate.gradeslate.backend.FileSystem;

public class course_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
    }


    public void toGrades(View view) {
            Intent goToNextActivity = new Intent(view.getContext(), GradeList.class);
            startActivity(goToNextActivity);
        Intent intent = new Intent(this, GradeList.class);
        startActivity(intent);
    }

    public void toProf(View view){
        Intent intent = new Intent(this, ProfInfo.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        FileSystem.getInstance().writeSemesters(this);
    }

}//end of class