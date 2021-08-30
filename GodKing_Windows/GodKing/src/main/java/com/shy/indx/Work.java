package com.shy.indx;


import com.shy.jdbc.DBConnection;
import com.shy.jdbc.Work_itme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
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

public class Work extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Work frame = new Work();
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
    public Work() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1005, 575);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton tab = new JButton("作息");
        tab.setBackground(Color.CYAN);
        tab.setForeground(Color.BLACK);
        tab.setFont(new Font("宋体", Font.PLAIN, 45));

        JButton not = new JButton("日志");
        not.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Notes().setVisible(true);
            }
        });
        not.setFont(new Font("宋体", Font.PLAIN, 45));

        JButton wea = new JButton("天气");
        wea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Weather().setVisible(true);
            }
        });
        wea.setFont(new Font("宋体", Font.PLAIN, 45));

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        table.setModel(new DefaultTableModel(
                work(),
                new String[]{"星期一","星期二", "星期三", "星期四", "星期五","星期六","星期日"}
        ));
        scrollPane.setViewportView(table);

        JButton up_tab = new JButton("更改");
        up_tab.setFont(new Font("宋体", Font.PLAIN, 20));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(tab, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(not, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(wea, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 726, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(up_tab, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(44)
                                                .addComponent(tab, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(not, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(wea, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(up_tab, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
        );


        contentPane.setLayout(gl_contentPane);
    }
    public Object[][] work() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Work_itme> workList = new ArrayList<>();
        try {
            String sql = "select * from work";
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Work_itme work = new Work_itme();
                work.setMonday(resultSet.getString(1));
                work.setTuesday(resultSet.getString("tuesday"));
                work.setWednesday(resultSet.getString("wednesday"));
                work.setThursday(resultSet.getString("thursday"));
                work.setFriday(resultSet.getString("friday"));
                work.setSaturday(resultSet.getString("saturday"));
                work.setSunday(resultSet.getString("sunday"));
                workList.add(work);
            }
            DBConnection.colse(resultSet, ps, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Object[][] data = new Object[workList.size()][7];
//        //循环遍历list，给二维数组赋值
        for (int i = 0; i < workList.size(); i++) {
            data[i][0] = workList.get(i).getMonday();
            data[i][1] = workList.get(i).getTuesday();
            data[i][2] = workList.get(i).getWednesday();
            data[i][3] = workList.get(i).getThursday();
            data[i][4] = workList.get(i).getFriday();
            data[i][5] = workList.get(i).getSaturday();
            data[i][6] = workList.get(i).getSunday();

        }
        return data;
    }
}

