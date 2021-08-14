package com.shy.godking.index;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shy.godking.R;
import com.shy.godking.jdbc.DBConnection;
import com.shy.godking.jdbc.Work;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Add_NotesActivity extends AppCompatActivity {

    String te_1;
    EditText te_2;
    EditText te_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        te_2 = findViewById(R.id.te_2);
        te_3 = findViewById(R.id.te_3);
        Button tn_s = findViewById(R.id.tn_s);
        tn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                te_1 = format.format(new Date());
                if (te_2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"请填写标题",Toast.LENGTH_LONG).show();
                }else {
                    add(te_1,te_2.getText().toString(),te_3.getText().toString());
                    Intent intent = new Intent(Add_NotesActivity.this,IndexActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button bn_e = findViewById(R.id.tn_e);
        bn_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_NotesActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });
    }
    public void add(String date, String title,String con){
        new Thread(){
            @Override
            public void run() {
                super.run();
                Connection connection = null;
                PreparedStatement ps = null;
                try {
                    String sql = "insert into notes(data,title,content)" + "values (?,?,?)";
                    connection = DBConnection.getConnection();
                    ps = connection.prepareStatement(sql);
                    ps.setString(1,date);
                    ps.setString(2,title);
                    ps.setString(3,con);
                    int i = ps. executeUpdate();
                    System.out.println(1);
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }.start();
    }
}