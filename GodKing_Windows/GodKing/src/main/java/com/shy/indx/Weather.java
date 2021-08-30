package com.shy.indx;

import com.shy.list_weather.AddressUtils;
import com.shy.list_weather.HourWeather;
import com.shy.list_weather.W24h;
import com.shy.list_weather.Weather_item;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Weather extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Weather frame = new Weather();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Weather() {

        String map = AddressUtils.getCity("");
        List<Weather_item> data = new ArrayList<>();
        W24h w24h = new W24h();
        List<HourWeather> weatherList = w24h.w24h("e8e17d73c85f4019887d3faecfea4ada",map);
        for (int i = 0; i < weatherList.size(); i++) {
            Weather_item weather = new Weather_item();
            weather.setHour(weatherList.get(i).getHour());
            weather.setWeather(weatherList.get(i).getWeather());
            weather.setTemperature(weatherList.get(i).getTemperature());
            data.add(weather);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 937, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton wea = new JButton("天气");
        wea.setForeground(Color.BLACK);
        wea.setFont(new Font("宋体", Font.PLAIN, 45));
        wea.setBackground(Color.CYAN);

        JButton tab = new JButton("作息");
        tab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Work().setVisible(true);
            }
        });
        tab.setFont(new Font("宋体", Font.PLAIN, 45));

        JButton not = new JButton("日志");
        not.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Notes().setVisible(true);
            }
        });
        not.setFont(new Font("宋体", Font.PLAIN, 45));

        JLabel lblNewLabel = new JLabel("当前地址：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));

        JLabel addr = new JLabel(map);
        addr.setFont(new Font("宋体", Font.PLAIN, 20));

        JLabel lblNewLabel_2 = new JLabel("当前温度：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));

        JLabel tem = new JLabel(data.get(0).getTemperature());
        tem.setFont(new Font("宋体", Font.PLAIN, 20));

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        table.setModel(new DefaultTableModel(
                wea(),
                new String[]{"小时","温度", "天气"}
        ));
        scrollPane.setViewportView(table);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(tab, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(not, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wea, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(46)
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(addr, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(tem, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                .addGap(76))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(32)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(tab, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(not, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(wea, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(tem, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(addr, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );


        contentPane.setLayout(gl_contentPane);
    }
    public Object[][] wea() {
        String map = AddressUtils.getCity("");
        List<Weather_item> wea = new ArrayList<>();
        W24h w24h = new W24h();
        List<HourWeather> weatherList = w24h.w24h("e8e17d73c85f4019887d3faecfea4ada",map);
        for (int i = 0; i < weatherList.size(); i++) {
            Weather_item weather = new Weather_item();
            weather.setHour(weatherList.get(i).getHour());
            weather.setWeather(weatherList.get(i).getWeather());
            weather.setTemperature(weatherList.get(i).getTemperature());
            wea.add(weather);
        }
        Object[][] data = new Object[wea.size()][7];
//        //循环遍历list，给二维数组赋值
        for (int i = 0; i < wea.size(); i++) {
            data[i][0] = wea.get(i).getHour();
            data[i][1] = wea.get(i).getTemperature();
            data[i][2] = wea.get(i).getWeather();

        }
        return data;
    }
}
