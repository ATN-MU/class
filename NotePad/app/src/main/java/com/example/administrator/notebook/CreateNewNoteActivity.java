package com.example.administrator.notebook;

import android.media.Image;
import android.os.Handler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CreateNewNoteActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private EditText titleEdit;
    private EditText bodyEdit;
    private ImageButton saveButton;
    private ImageButton cancelButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnote);
        titleEdit=findViewById(R.id.editTitle);
        bodyEdit=findViewById(R.id.editBody);
        saveButton=findViewById(R.id.editSave);
        cancelButton=findViewById(R.id.editCancel);
        dbHelper=new DBHelper(this);
        db=dbHelper.getWritableDatabase();
        bindListening();
    }
    public void bindListening(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=titleEdit.getText().toString();
                String body=bodyEdit.getText().toString();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                Date date=new Date(System.currentTimeMillis());
                String cdate=simpleDateFormat.format(date);
                db.execSQL("insert into notes(title,body,date) values('"+title+"','"+body+"','"+cdate+"')");
                Toast.makeText(CreateNewNoteActivity.this,"添加成功!",Toast.LENGTH_SHORT).show();
                MainActivity.myHandler.sendEmptyMessage(0x123);
                finish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
