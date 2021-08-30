package com.shy.indx;

import com.shy.jdbc.Bean;
import com.shy.jdbc.DBConnection;
import com.shy.jdbc.Work_itme;

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
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Notes extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Notes frame = new Notes();
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
    public Notes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 998, 569);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton not = new JButton("日志");
        not.setForeground(Color.BLACK);
        not.setFont(new Font("宋体", Font.PLAIN, 45));
        not.setBackground(Color.CYAN);

        final JButton tab = new JButton("作息");
        tab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Work().setVisible(true);
            }
        });
        tab.setFont(new Font("宋体", Font.PLAIN, 45));

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
                notes(),
                new String[]{"时间","主题", "内容","编号"}
        ));
        scrollPane.setViewportView(table);

        JButton add_not = new JButton("新增");
        add_not.setFont(new Font("宋体", Font.PLAIN, 20));
        add_not.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new NotesAdd().setVisible(true);
            }
        });

        JButton del_not = new JButton("删除");
        del_not.setFont(new Font("宋体", Font.PLAIN, 20));
        del_not.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String id = table.getValueAt(row,3).toString();
                Connection connection = null;
                PreparedStatement ps = null;
                try {
                    String sql = "delete from notes where id = ?";
                    connection = DBConnection.getConnection();
                    ps = connection.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(id));
                    int i = ps.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
                new Notes().setVisible(true);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(wea, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(not, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tab, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
                                                .addGap(25))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(84)
                                                .addComponent(add_not, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                                                .addGap(188)
                                                .addComponent(del_not, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                                                .addGap(110))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(add_not, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(del_not, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(43, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(29)
                                .addComponent(tab, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(not, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(wea, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE))
        );


        contentPane.setLayout(gl_contentPane);
    }
    public Object[][] notes() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Bean> beans = new ArrayList<>();
        try {
            String sql = "select * from notes";
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Bean bean = new Bean();
                bean.setId(resultSet.getInt("id"));
                bean.setData(resultSet.getString("data"));
                bean.setTitle(resultSet.getString("title"));
                bean.setContent(resultSet.getString("content"));
                beans.add(bean);
            }
            DBConnection.colse(resultSet, ps, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Object[][] data = new Object[beans.size()][4];
//        //循环遍历list，给二维数组赋值
        for (int i = 0; i < beans.size(); i++) {
            data[i][0] = beans.get(i).getData();
            data[i][1] = beans.get(i).getTitle();
            data[i][2] = beans.get(i).getContent();
            data[i][3] = beans.get(i).getId();
        }
        return data;
    }


}
