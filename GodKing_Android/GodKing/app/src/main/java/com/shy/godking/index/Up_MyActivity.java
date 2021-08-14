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
import com.shy.godking.jdbc.User;
import com.shy.godking.login.MainActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Up_MyActivity extends AppCompatActivity {

    EditText up_username_e;
    EditText old_pass;
    EditText new_pass;
    EditText new_pass_ok;

    String msg_username;
    String msg_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_my);

        up_username_e = findViewById(R.id.up_username_e);
        old_pass = findViewById(R.id.old_pass);
        new_pass = findViewById(R.id.new_pass);
        new_pass_ok = findViewById(R.id.new_pass_ok);

        Button up_username = findViewById(R.id.up_username);
        up_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                up_username(up_username_e.getText().toString(), MainActivity.id);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Toast.makeText(getApplicationContext(), msg_username, Toast.LENGTH_LONG).show();
            }
        });
        Button up_pass = findViewById(R.id.up_pass);
        up_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (new_pass.getText().toString().equals(new_pass_ok.getText().toString())) {
//                    up_pass(old_pass.getText().toString(), new_pass.getText().toString(),MainActivity.id);
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    Toast.makeText(getApplicationContext(),msg_pass,Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "两个密码不一样，请重写", Toast.LENGTH_LONG).show();
//                }
            }
        });

        Button exit = findViewById(R.id.exit_my);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Up_MyActivity.this, IndexActivity.class);
                startActivity(intent);
            }
        });
    }

    public void up_username(String username, int id) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                Connection connection = null;
                PreparedStatement ps = null;
                ResultSet resultSet = null;
                List<User> loginList = new ArrayList<>();
                try {
                    String sql = "select * from user";
                    connection = DBConnection.getConnection();
                    ps = connection.prepareStatement(sql);
                    resultSet = ps.executeQuery();
                    while (resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getInt("id"));
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        loginList.add(user);
                    }
                    boolean flg = false;
                    for (int i = 0; i < loginList.size(); i++) {
                        if (loginList.get(i).getUsername().equals(username)) {
                            msg_username = "账号已经存在，请重写";
                            return;
                        } else {
                            msg_username = "更改成功";
                            flg = true;
                        }
                    }
                    if (flg) {
                        String sql1 = "update user set username=? WHERE id = ?";
                        connection = DBConnection.getConnection();
                        ps = connection.prepareStatement(sql1);
                        ps.setString(1, username);
                        ps.setInt(2, id);
                        int i = ps.executeUpdate();
                    }
                    DBConnection.colse(resultSet, ps, connection);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }.start();
    }

    public void up_pass(String old_pass, String new_pass, int id) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                Connection connection = null;
                PreparedStatement ps = null;
                ResultSet resultSet = null;
                List<User> loginList = new ArrayList<>();
                try {
                    String sql = "select * from user";
                    connection = DBConnection.getConnection();
                    ps = connection.prepareStatement(sql);
                    resultSet = ps.executeQuery();
                    while (resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getInt("id"));
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        loginList.add(user);
                    }
                    String pass = null;
                    for (int i = 0; i < loginList.size(); i++) {
                        if (loginList.get(i).getId() == MainActivity.id){
                            pass = loginList.get(i).getPassword();
                        }
                    }
                    System.out.println(pass);
                    if (pass.equals(old_pass)){
                        String sql1 = "update user set password=? WHERE id = ?";
                        connection = DBConnection.getConnection();
                        ps = connection.prepareStatement(sql1);
                        ps.setString(1, new_pass);
                        ps.setInt(2, id);
                        int i = ps.executeUpdate();
                        msg_pass = "更改成功";
                    }else {
                        msg_pass = "密码错误";
                    }
                    DBConnection.colse(resultSet, ps, connection);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }.start();
    }
}