package com.gradeslate.gradeslate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gradeslate.gradeslate.backend.Course;
import com.gradeslate.gradeslate.backend.FileSystem;

public class ProfInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_info);
        EditText editName = (EditText) findViewById(R.id.nameHint);
        EditText editLoc = (EditText) findViewById(R.id.locationHint);
        EditText editEmail = (EditText) findViewById(R.id.emailHint);
        EditText editHour = (EditText) findViewById(R.id.hourHint);
        String name = FileSystem.getInstance().getCourse().getProf().getName();
        String email = FileSystem.getInstance().getCourse().getProf().getEmail();
        String hour = FileSystem.getInstance().getCourse().getProf().getOffHour();
        String location = FileSystem.getInstance().getCourse().getProf().getOffLoc();
        if ((name.replaceAll("\\s+","") != null) && (name.replaceAll("\\s+","") != "")) {
            editName.setHint("Name");
        } else {
            editName.setHint(name);
        }
        if ((email.replaceAll("\\s+","") != null) && (email.replaceAll("\\s+","") != "")) {
            editEmail.setHint("Email");
        } else {
            editEmail.setHint(email);
        }
        if ((hour.replaceAll("\\s+","") != null) && (hour.replaceAll("\\s+","") != "")) {
            editHour.setHint("Hour");
        } else {
            editHour.setHint(hour);
        }
        if ((location.replaceAll("\\s+","") != null) && (location.replaceAll("\\s+","") != "")) {
            editLoc.setHint("Office Location");
        } else {
            editLoc.setHint(location);
        }
        editProfNameOnButtonClick();
        editEmailOnButtonClick();
        editLocationOnButtonClick();
        editHourOnButtonClick();

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        FileSystem.getInstance().writeSemesters(this);
    }

    private void editProfNameOnButtonClick() {

        final EditText editText = (EditText) findViewById(R.id.nameHint);
        Button editButton = (Button) findViewById(R.id.nameButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String newName = editText.getText().toString();
                editText.setText("");
                if((newName.replaceAll("\\s+","") != null) && (newName.replaceAll("\\s+","") != "")) {
                    FileSystem.getInstance().getCourse().getProf().setName(newName);
                }
                editText.setHint(FileSystem.getInstance().getCourse().getProf().getName());
            }
        });
    }

    private void editEmailOnButtonClick() {

        final EditText editText = (EditText) findViewById(R.id.emailHint);
        Button editButton = (Button) findViewById(R.id.updateEmail);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String email = editText.getText().toString();
                editText.setText("");
                if((email.replaceAll("\\s+","") != null) && (email.replaceAll("\\s+","") != "")) {
                    FileSystem.getInstance().getCourse().getProf().setEmail(email);
                }
                editText.setHint(FileSystem.getInstance().getCourse().getProf().getEmail());
            }
        });
    }

    private void editHourOnButtonClick() {

        final EditText editText = (EditText) findViewById(R.id.hourHint);
        Button editButton = (Button) findViewById(R.id.hourButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String hour = editText.getText().toString();
                editText.setText("");
                if((hour.replaceAll("\\s+","") != null) && (hour.replaceAll("\\s+","") != "")) {
                    FileSystem.getInstance().getCourse().getProf().setOffHour(hour);
                }
                editText.setHint(FileSystem.getInstance().getCourse().getProf().getOffHour());
            }
        });
    }

    private void editLocationOnButtonClick() {

        final EditText editText = (EditText) findViewById(R.id.locationHint);
        Button editButton = (Button) findViewById(R.id.locationButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String location = editText.getText().toString();
                editText.setText("");
                if((location.replaceAll("\\s+","") != null) && (location.replaceAll("\\s+","") != "")) {
                    FileSystem.getInstance().getCourse().getProf().setOffLoc(location);
                }
                editText.setHint(FileSystem.getInstance().getCourse().getProf().getOffLoc());
            }
        });
    }





}//end of class
