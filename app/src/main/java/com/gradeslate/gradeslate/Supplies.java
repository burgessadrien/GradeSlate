package com.gradeslate.gradeslate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.gradeslate.gradeslate.backend.FileSystem;

import java.util.ArrayList;

public class Supplies extends AppCompatActivity {
    private FloatingActionButton fab;
    private EditText mItem;
    private ArrayList<String> itemNames;
    private String supply;
    private ArrayAdapter<String> adapter;
    private String item;
    private String empty = "Please add a item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplies);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addNames();
        ListView listview = (ListView) findViewById(R.id.supplies);
        adapter = new ArrayAdapter<String>(this, R.layout.supplies_item, R.id.item_name, itemNames);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                try {
                    item = String.valueOf(parent.getItemAtPosition(position));
                    String found = findItem(position);
                    if (found != null) {
                         Toast.makeText(Supplies.this,
                                found, Toast.LENGTH_SHORT).show();
                        FileSystem.getInstance().getCourse().getBag().addItem(found);
                    }
                }catch(Exception e){
                    Toast.makeText(Supplies.this,
                            "Add Item", Toast.LENGTH_SHORT).show();
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
                final AlertDialog dialog = new AlertDialog.Builder(Supplies.this).create();
                View mView = getLayoutInflater().inflate(R.layout.dialog_supplies, null);
                mItem = (EditText) mView.findViewById(R.id.editItem);
                Button mAdd = (Button) mView.findViewById(R.id.addItem);
                mAdd.setOnClickListener(new View.OnClickListener()  {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (!mItem.getText().toString().isEmpty()) {
                                // Toast.makeText(courseList.this,
                                //       R.string.semesterAddedMsg, Toast.LENGTH_SHORT).show();
                                item = mItem.getText().toString();

                                Boolean add = FileSystem.getInstance().getCourse().getBag().addItem(item);
                                if(add==true) {
                                    if (itemNames.get(0) == empty) {
                                        itemNames.clear();
                                        itemNames.add(item);
                                    } else {
                                        itemNames.add(item);
                                    }

                                    adapter.notifyDataSetChanged();
                                    String test = item;
                                    Toast.makeText(Supplies.this,
                                            test, Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }

                            } else {
                                Toast.makeText(Supplies.this,
                                        "error", Toast.LENGTH_SHORT).show();
                            }
                        }catch(Exception e){}

                    }
                });
                dialog.setView(mView);
                dialog.show();

            }
        });
    }//end of onFabClick



    public void addNames(){
        this.itemNames = new ArrayList<String>();

        for(int i = 0; i < FileSystem.getInstance().getCourse().getBag().getItems().size(); i++){
            this.itemNames.add(FileSystem.getInstance().getCourse().getBag().getItem(i).getType());
        }
        if(itemNames.isEmpty()){
            itemNames.add(empty);
        }
    }

    public String findItem(int position){
        if(FileSystem.getInstance().getGrades().getEvaluations().get(position) != null){
            return FileSystem.getInstance().getCourse().getBag().getItem(position).getType();
        }
        return null;
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        FileSystem.getInstance().writeSemesters(this);
    }

}//end of class
