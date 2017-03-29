package com.gradeslate.gradeslate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gradeslate.gradeslate.backend.FileSystem;

public class grade_info extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_info);
        EditText editName =  (EditText) findViewById(R.id.typeHint);
        EditText editWorth =  (EditText) findViewById(R.id.worthHint);
        EditText editGrade =  (EditText) findViewById(R.id.gradeHint);
        EditText editDate =  (EditText) findViewById(R.id.dateHint);

        String type = FileSystem.getInstance().getGrade().getType();
        String date = FileSystem.getInstance().getGrade().getDue();
        String worth = String.valueOf(FileSystem.getInstance().getGrade().getWorth());
        String grade = String.valueOf(FileSystem.getInstance().getGrade().getGrade());

        if((type.replaceAll("\\s+","") != null) && (type.replaceAll("\\s+","")!="")) {
            editName.setHint(type);
        }
        else{
            editName.setHint("Eval Name");
        }
        if((worth.replaceAll("\\s+","") != null) && (worth.replaceAll("\\s+","")!="")) {
            editWorth.setHint(worth);
        }
        else{
            editWorth.setHint("Percent Worth");
        }
        if((date.replaceAll("\\s+","") != null) && (date.replaceAll("\\s+","")!="")) {
            editDate.setHint(date);
        }
        else{
            editDate.setHint("Date");
        }
        if((grade.replaceAll("\\s+","") != null) && (grade.replaceAll("\\s+","")!="")) {
            editGrade.setHint(grade);
        }
        else{
            editGrade.setHint("Grade");
        }

        editTypeOnButtonClick();
        editWorthOnButtonClick();
        editGradeOnButtonClick();
        editDateOnButtonClick();

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        FileSystem.getInstance().writeSemesters(this);
    }

    private void editTypeOnButtonClick() {

        final EditText editText = (EditText) findViewById(R.id.typeHint);
        Button editButton = (Button) findViewById(R.id.typeButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String type = editText.getText().toString();
                editText.setText("");
                if((type.replaceAll("\\s+","") != null) && (type.replaceAll("\\s+","") != "")) {
                    FileSystem.getInstance().getCourse().getProf().setName(type);
                }
                editText.setHint(FileSystem.getInstance().getGrade().getType());
            }
        });
    }

    private void editWorthOnButtonClick() {

        final EditText editText = (EditText) findViewById(R.id.worthHint);
        Button editButton = (Button) findViewById(R.id.editWorth);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String worth = editText.getText().toString();
                editText.setText("");
                if((worth.replaceAll("\\s+","") != null) && (worth.replaceAll("\\s+","") != "")) {
                    float use = Float.valueOf(worth);
                    FileSystem.getInstance().getGrade().setWorth(use);
                }
                editText.setHint(String.valueOf(FileSystem.getInstance().getGrade().getWorth()));
            }
        });
    }

    private void editDateOnButtonClick() {

        final EditText editText = (EditText) findViewById(R.id.dateHint);
        Button editButton = (Button) findViewById(R.id.dateButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String date = editText.getText().toString();
                editText.setText("");
                if((date.replaceAll("\\s+","") != null) && (date.replaceAll("\\s+","") != "")) {
                    FileSystem.getInstance().getGrade().setDue(date);
                }
                editText.setHint(FileSystem.getInstance().getGrade().getDue());
            }
        });
    }

    private void editGradeOnButtonClick() {

        final EditText editText = (EditText) findViewById(R.id.gradeHint);
        Button editButton = (Button) findViewById(R.id.gradeButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String mark = editText.getText().toString();
                editText.setText("");
                if((mark.replaceAll("\\s+","") != null) && (mark.replaceAll("\\s+","") != "")) {
                    float val = Float.valueOf(mark);
                    FileSystem.getInstance().getGrade().setGrade(val);
                }
                editText.setHint(String.valueOf(FileSystem.getInstance().getGrade().getGrade()));
            }
        });
    }
}
