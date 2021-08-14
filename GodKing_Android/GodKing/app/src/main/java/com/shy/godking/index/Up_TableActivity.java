package com.shy.godking.index;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shy.godking.R;
import com.shy.godking.jdbc.DBConnection;
import com.shy.godking.jdbc.User;
import com.shy.godking.jdbc.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Up_TableActivity extends AppCompatActivity {
    TextView viewe1_1;
    TextView viewe1_2;
    TextView viewe1_3;
    TextView viewe1_4;
    TextView viewe1_5;
    TextView viewe1_6;
    TextView viewe1_7;
    TextView viewe2_1;
    TextView viewe2_2;
    TextView viewe2_3;
    TextView viewe2_4;
    TextView viewe2_5;
    TextView viewe2_6;
    TextView viewe2_7;
    TextView viewe3_1;
    TextView viewe3_2;
    TextView viewe3_3;
    TextView viewe3_4;
    TextView viewe3_5;
    TextView viewe3_6;
    TextView viewe3_7;
    TextView viewe4_1;
    TextView viewe4_2;
    TextView viewe4_3;
    TextView viewe4_4;
    TextView viewe4_5;
    TextView viewe4_6;
    TextView viewe4_7;
    TextView viewe5_1;
    TextView viewe5_2;
    TextView viewe5_3;
    TextView viewe5_4;
    TextView viewe5_5;
    TextView viewe5_6;
    TextView viewe5_7;
    TextView viewe6_1;
    TextView viewe6_2;
    TextView viewe6_3;
    TextView viewe6_4;
    TextView viewe6_5;
    TextView viewe6_6;
    TextView viewe6_7;
    TextView viewe7_1;
    TextView viewe7_2;
    TextView viewe7_3;
    TextView viewe7_4;
    TextView viewe7_5;
    TextView viewe7_6;
    TextView viewe7_7;
    TextView viewe8_1;
    TextView viewe8_2;
    TextView viewe8_3;
    TextView viewe8_4;
    TextView viewe8_5;
    TextView viewe8_6;
    TextView viewe8_7;
    TextView viewe9_1;
    TextView viewe9_2;
    TextView viewe9_3;
    TextView viewe9_4;
    TextView viewe9_5;
    TextView viewe9_6;
    TextView viewe9_7;
    TextView viewe10_1;
    TextView viewe10_2;
    TextView viewe10_3;
    TextView viewe10_4;
    TextView viewe10_5;
    TextView viewe10_6;
    TextView viewe10_7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_table);
        viewe1_1 = findViewById(R.id.te1_1);
        viewe1_2 = findViewById(R.id.te1_2);
        viewe1_3 = findViewById(R.id.te1_3);
        viewe1_4 = findViewById(R.id.te1_4);
        viewe1_5 = findViewById(R.id.te1_5);
        viewe1_6 = findViewById(R.id.te1_6);
        viewe1_7 = findViewById(R.id.te1_7);
        viewe2_1 = findViewById(R.id.te2_1);
        viewe2_2 = findViewById(R.id.te2_2);
        viewe2_3 = findViewById(R.id.te2_3);
        viewe2_4 = findViewById(R.id.te2_4);
        viewe2_5 = findViewById(R.id.te2_5);
        viewe2_6 = findViewById(R.id.te2_6);
        viewe2_7 = findViewById(R.id.te2_7);
        viewe3_1 = findViewById(R.id.te3_1);
        viewe3_2 = findViewById(R.id.te3_2);
        viewe3_3 = findViewById(R.id.te3_3);
        viewe3_4 = findViewById(R.id.te3_4);
        viewe3_5 = findViewById(R.id.te3_5);
        viewe3_6 = findViewById(R.id.te3_6);
        viewe3_7 = findViewById(R.id.te3_7);
        viewe4_1 = findViewById(R.id.te4_1);
        viewe4_2 = findViewById(R.id.te4_2);
        viewe4_3 = findViewById(R.id.te4_3);
        viewe4_4 = findViewById(R.id.te4_4);
        viewe4_5 = findViewById(R.id.te4_5);
        viewe4_6 = findViewById(R.id.te4_6);
        viewe4_7 = findViewById(R.id.te4_7);
        viewe5_1 = findViewById(R.id.te5_1);
        viewe5_2 = findViewById(R.id.te5_2);
        viewe5_3 = findViewById(R.id.te5_3);
        viewe5_4 = findViewById(R.id.te5_4);
        viewe5_5 = findViewById(R.id.te5_5);
        viewe5_6 = findViewById(R.id.te5_6);
        viewe5_7 = findViewById(R.id.te5_7);
        viewe6_1 = findViewById(R.id.te6_1);
        viewe6_2 = findViewById(R.id.te6_2);
        viewe6_3 = findViewById(R.id.te6_3);
        viewe6_4 = findViewById(R.id.te6_4);
        viewe6_5 = findViewById(R.id.te6_5);
        viewe6_6 = findViewById(R.id.te6_6);
        viewe6_7 = findViewById(R.id.te6_7);
        viewe7_1 = findViewById(R.id.te7_1);
        viewe7_2 = findViewById(R.id.te7_2);
        viewe7_3 = findViewById(R.id.te7_3);
        viewe7_4 = findViewById(R.id.te7_4);
        viewe7_5 = findViewById(R.id.te7_5);
        viewe7_6 = findViewById(R.id.te7_6);
        viewe7_7 = findViewById(R.id.te7_7);
        viewe8_1 = findViewById(R.id.te8_1);
        viewe8_2 = findViewById(R.id.te8_2);
        viewe8_3 = findViewById(R.id.te8_3);
        viewe8_4 = findViewById(R.id.te8_4);
        viewe8_5 = findViewById(R.id.te8_5);
        viewe8_6 = findViewById(R.id.te8_6);
        viewe8_7 = findViewById(R.id.te8_7);
        viewe9_1 = findViewById(R.id.te9_1);
        viewe9_2 = findViewById(R.id.te9_2);
        viewe9_3 = findViewById(R.id.te9_3);
        viewe9_4 = findViewById(R.id.te9_4);
        viewe9_5 = findViewById(R.id.te9_5);
        viewe9_6 = findViewById(R.id.te9_6);
        viewe9_7 = findViewById(R.id.te9_7);
        viewe10_1 = findViewById(R.id.te10_1);
        viewe10_2 = findViewById(R.id.te10_2);
        viewe10_3 = findViewById(R.id.te10_3);
        viewe10_4 = findViewById(R.id.te10_4);
        viewe10_5 = findViewById(R.id.te10_5);
        viewe10_6 = findViewById(R.id.te10_6);
        viewe10_7 = findViewById(R.id.te10_7);
        List<Work> works = TableFragment.works;
        viewe1_1.setText(works.get(0).getMonday());
        viewe1_2.setText(works.get(0).getTuesday());
        viewe1_3.setText(works.get(0).getWednesday());
        viewe1_4.setText(works.get(0).getThursday());
        viewe1_5.setText(works.get(0).getFriday());
        viewe1_6.setText(works.get(0).getSaturday());
        viewe1_7.setText(works.get(0).getSunday());
        viewe2_1.setText(works.get(1).getMonday());
        viewe2_2.setText(works.get(1).getTuesday());
        viewe2_3.setText(works.get(1).getWednesday());
        viewe2_4.setText(works.get(1).getThursday());
        viewe2_5.setText(works.get(1).getFriday());
        viewe2_6.setText(works.get(1).getSaturday());
        viewe2_7.setText(works.get(1).getSunday());
        viewe3_1.setText(works.get(2).getMonday());
        viewe3_2.setText(works.get(2).getTuesday());
        viewe3_3.setText(works.get(2).getWednesday());
        viewe3_4.setText(works.get(2).getThursday());
        viewe3_5.setText(works.get(2).getFriday());
        viewe3_6.setText(works.get(2).getSaturday());
        viewe3_7.setText(works.get(2).getSunday());
        viewe4_1.setText(works.get(3).getMonday());
        viewe4_2.setText(works.get(3).getTuesday());
        viewe4_3.setText(works.get(3).getWednesday());
        viewe4_4.setText(works.get(3).getThursday());
        viewe4_5.setText(works.get(3).getFriday());
        viewe4_6.setText(works.get(3).getSaturday());
        viewe4_7.setText(works.get(3).getSunday());
        viewe5_1.setText(works.get(4).getMonday());
        viewe5_2.setText(works.get(4).getTuesday());
        viewe5_3.setText(works.get(4).getWednesday());
        viewe5_4.setText(works.get(4).getThursday());
        viewe5_5.setText(works.get(4).getFriday());
        viewe5_6.setText(works.get(4).getSaturday());
        viewe5_7.setText(works.get(4).getSunday());
        viewe6_1.setText(works.get(5).getMonday());
        viewe6_2.setText(works.get(5).getTuesday());
        viewe6_3.setText(works.get(5).getWednesday());
        viewe6_4.setText(works.get(5).getThursday());
        viewe6_5.setText(works.get(5).getFriday());
        viewe6_6.setText(works.get(5).getSaturday());
        viewe6_7.setText(works.get(5).getSunday());
        viewe7_1.setText(works.get(6).getMonday());
        viewe7_2.setText(works.get(6).getTuesday());
        viewe7_3.setText(works.get(6).getWednesday());
        viewe7_4.setText(works.get(6).getThursday());
        viewe7_5.setText(works.get(6).getFriday());
        viewe7_6.setText(works.get(6).getSaturday());
        viewe7_7.setText(works.get(6).getSunday());
        viewe8_1.setText(works.get(7).getMonday());
        viewe8_2.setText(works.get(7).getTuesday());
        viewe8_3.setText(works.get(7).getWednesday());
        viewe8_4.setText(works.get(7).getThursday());
        viewe8_5.setText(works.get(7).getFriday());
        viewe8_6.setText(works.get(7).getSaturday());
        viewe8_7.setText(works.get(7).getSunday());
        viewe9_1.setText(works.get(8).getMonday());
        viewe9_2.setText(works.get(8).getTuesday());
        viewe9_3.setText(works.get(8).getWednesday());
        viewe9_4.setText(works.get(8).getThursday());
        viewe9_5.setText(works.get(8).getFriday());
        viewe9_6.setText(works.get(8).getSaturday());
        viewe9_7.setText(works.get(8).getSunday());
        viewe10_1.setText(works.get(9).getMonday());
        viewe10_2.setText(works.get(9).getTuesday());
        viewe10_3.setText(works.get(9).getWednesday());
        viewe10_4.setText(works.get(9).getThursday());
        viewe10_5.setText(works.get(9).getFriday());
        viewe10_6.setText(works.get(9).getSaturday());
        viewe10_7.setText(works.get(9).getSunday());
        Button s = findViewById(R.id.s);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Work work = new Work();
                work.setMonday(viewe1_1.getText().toString());
                work.setTuesday(viewe1_2.getText().toString());
                work.setWednesday(viewe1_3.getText().toString());
                work.setThursday(viewe1_4.getText().toString());
                work.setFriday(viewe1_5.getText().toString());
                work.setSaturday(viewe1_6.getText().toString());
                work.setSunday(viewe1_7.getText().toString());
                update(work);
                Intent intent = new Intent(Up_TableActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });
        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Up_TableActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });
    }

    public void update(Work work){
        new Thread(){
            @Override
            public void run() {
                super.run();
                Connection connection = null;
                PreparedStatement ps = null;
                System.out.println(work.getFriday());
                Work work1 = work;
                try {
                    String sql = "update work set ? where id = 1;";
                    connection = DBConnection.getConnection();
                    ps = connection.prepareStatement(sql);
                    ps.setObject(1,work1);
                    boolean i = ps. execute();
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }.start();
    }
}