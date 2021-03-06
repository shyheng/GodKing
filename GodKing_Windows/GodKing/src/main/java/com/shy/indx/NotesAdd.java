package com.shy.indx;


import com.shy.jdbc.DBConnection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesAdd extends JFrame {

    private JPanel contentPane;
    private JTextField title;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NotesAdd frame = new NotesAdd();
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
    public NotesAdd() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 901, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("主题");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 35));

        title = new JTextField();
        title.setColumns(10);

        lblNewLabel_1 = new JLabel("内容");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 35));

        final JTextArea con = new JTextArea();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        final String date = format.format(new Date());

        JButton btnNewButton = new JButton("提交");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                PreparedStatement ps = null;
                try {
                    String sql = "insert into notes(data,title,content)" + "values (?,?,?)";
                    connection = DBConnection.getConnection();
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, date);
                    ps.setString(2, title.getText());
                    ps.setString(3, con.getText());
                    int i = ps.executeUpdate();
                } catch (
                        SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
                new Notes().setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));

        JButton btnNewButton_1 = new JButton("返回");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Notes().setVisible(true);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(178)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(con, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(235, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(81)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                .addGap(118))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(19)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(title)
                                        .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                .addGap(18)
                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(con, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                .addGap(39)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

}

