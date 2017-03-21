package com.gradeslate.gradeslate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gradeslate.gradeslate.backend.FileSystem;

public class EnterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_screen);

        FileSystem.getInstance().readSemesters(this);
    }

    public void enterMessage(View view){
        Intent intent = new Intent(this,CoursesList.class);
        startActivity(intent);
    }
}

