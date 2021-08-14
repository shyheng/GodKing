package com.shy.godking.index;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shy.godking.R;
import com.shy.godking.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotesItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_item);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        String title = intent.getStringExtra("title");
        String date = intent.getStringExtra("date");
        String con = intent.getStringExtra("con");

        TextView title_t = findViewById(R.id.title);
        TextView date_t = findViewById(R.id.date);
        TextView con_t = findViewById(R.id.con);

        title_t.setText(title);
        date_t.setText(date);
        con_t.setText(con);

        Button ni_1 = findViewById(R.id.ni_1);
        Button ni_2 = findViewById(R.id.ni_2);

        ni_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NotesItemActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });

        ni_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(id);
                Intent intent = new Intent(NotesItemActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });
    }

    public void delete(int id){
        new Thread(){
            @Override
            public void run() {
                super.run();
                Connection connection = null;
                PreparedStatement ps = null;
                try {
                    String sql = "delete from notes where id = ?";
                    connection = DBConnection.getConnection();
                    ps = connection.prepareStatement(sql);
                    ps.setInt(1,id);
                    int i = ps. executeUpdate();
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }.start();
    }
}