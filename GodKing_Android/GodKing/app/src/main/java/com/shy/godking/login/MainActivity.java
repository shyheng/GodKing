package com.shy.godking.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shy.godking.R;
import com.shy.godking.index.IndexActivity;
import com.shy.godking.jdbc.DBConnection;
import com.shy.godking.jdbc.User;
import com.shy.godking.list_weather.NetWorkUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String username;
    public static int id;

    EditText login_username;
    EditText login_pass;

    boolean flg_username = false;
    boolean flg_pass = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_username = findViewById(R.id.login_username);
        login_pass = findViewById(R.id.login_password);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetWorkUtils.checkEnable(getApplicationContext())){
//                    flg_username = false;
//                    flg_pass = false;
//                    query();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    if (flg_username){
//                        if (flg_pass){
//                            username = login_username.getText().toString();
                            Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                            startActivity(intent);
//                        }else {
//                            Toast.makeText(getApplicationContext(),"密码错误",Toast.LENGTH_LONG).show();
//                        }
//                    }else {
//                        Toast.makeText(getApplicationContext(),"没有此账号",Toast.LENGTH_LONG).show();
//                    }

                }else {
                    Toast.makeText(getApplicationContext(), "没有网络，无法登录，请保证是WIFI,或者请重新打开网络!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button reg =findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetWorkUtils.checkEnable(getApplicationContext())) {
                    Intent intent = new Intent(MainActivity.this, RegActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "没有网络，无法注册，请保证是WIFI,或者请重新打开网络!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void query(){
        new Thread(){
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
                    for (int i = 0; i < loginList.size(); i++) {
                        if (loginList.get(i).getUsername().equals(login_username.getText().toString())){
                            flg_username = true;
                            if (loginList.get(i).getPassword().equals(login_pass.getText().toString())){
                                flg_pass = true;
                                id = loginList.get(i).getId();
                            }
                        }
                    }
                    DBConnection.colse(resultSet,ps,connection);
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }.start();
    }

}