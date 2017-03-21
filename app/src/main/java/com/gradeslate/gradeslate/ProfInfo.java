package com.gradeslate.gradeslate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gradeslate.gradeslate.backend.FileSystem;

public class ProfInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_info);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        FileSystem.getInstance().writeSemesters(this);
    }


}//end of class
