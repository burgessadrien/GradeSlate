package com.gradeslate.gradeslate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EnterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_screen);
    }

    public void enterMessage(View view){
        Intent intent = new Intent(this,EditProf.class);
        startActivity(intent);
    }
}

