package com.shy.godking.index;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.shy.godking.R;
import com.shy.godking.jdbc.DBConnection;
import com.shy.godking.jdbc.User;
import com.shy.godking.jdbc.Work;
import com.shy.godking.list_weather.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TableFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TableFragment newInstance(String param1, String param2) {
        TableFragment fragment = new TableFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView view1_1;
    TextView view1_2;
    TextView view1_3;
    TextView view1_4;
    TextView view1_5;
    TextView view1_6;
    TextView view1_7;

    TextView view2_1;
    TextView view2_2;
    TextView view2_3;
    TextView view2_4;
    TextView view2_5;
    TextView view2_6;
    TextView view2_7;

    TextView view3_1;
    TextView view3_2;
    TextView view3_3;
    TextView view3_4;
    TextView view3_5;
    TextView view3_6;
    TextView view3_7;

    TextView view4_1;
    TextView view4_2;
    TextView view4_3;
    TextView view4_4;
    TextView view4_5;
    TextView view4_6;
    TextView view4_7;

    TextView view5_1;
    TextView view5_2;
    TextView view5_3;
    TextView view5_4;
    TextView view5_5;
    TextView view5_6;
    TextView view5_7;

    TextView view6_1;
    TextView view6_2;
    TextView view6_3;
    TextView view6_4;
    TextView view6_5;
    TextView view6_6;
    TextView view6_7;

    TextView view7_1;
    TextView view7_2;
    TextView view7_3;
    TextView view7_4;
    TextView view7_5;
    TextView view7_6;
    TextView view7_7;

    TextView view8_1;
    TextView view8_2;
    TextView view8_3;
    TextView view8_4;
    TextView view8_5;
    TextView view8_6;
    TextView view8_7;

    TextView view9_1;
    TextView view9_2;
    TextView view9_3;
    TextView view9_4;
    TextView view9_5;
    TextView view9_6;
    TextView view9_7;

    TextView view10_1;
    TextView view10_2;
    TextView view10_3;
    TextView view10_4;
    TextView view10_5;
    TextView view10_6;
    TextView view10_7;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_table, container, false);

        view1_1 = view.findViewById(R.id.t1_1);
        view1_2 = view.findViewById(R.id.t1_2);
        view1_3 = view.findViewById(R.id.t1_3);
        view1_4 = view.findViewById(R.id.t1_4);
        view1_5 = view.findViewById(R.id.t1_5);
        view1_6 = view.findViewById(R.id.t1_6);
        view1_7 = view.findViewById(R.id.t1_7);

        view2_1 = view.findViewById(R.id.t2_1);
        view2_2 = view.findViewById(R.id.t2_2);
        view2_3 = view.findViewById(R.id.t2_3);
        view2_4 = view.findViewById(R.id.t2_4);
        view2_5 = view.findViewById(R.id.t2_5);
        view2_6 = view.findViewById(R.id.t2_6);
        view2_7 = view.findViewById(R.id.t2_7);

        view3_1 = view.findViewById(R.id.t3_1);
        view3_2 = view.findViewById(R.id.t3_2);
        view3_3 = view.findViewById(R.id.t3_3);
        view3_4 = view.findViewById(R.id.t3_4);
        view3_5 = view.findViewById(R.id.t3_5);
        view3_6 = view.findViewById(R.id.t3_6);
        view3_7 = view.findViewById(R.id.t3_7);

        view4_1 = view.findViewById(R.id.t4_1);
        view4_2 = view.findViewById(R.id.t4_2);
        view4_3 = view.findViewById(R.id.t4_3);
        view4_4 = view.findViewById(R.id.t4_4);
        view4_5 = view.findViewById(R.id.t4_5);
        view4_6 = view.findViewById(R.id.t4_6);
        view4_7 = view.findViewById(R.id.t4_7);

        view5_1 = view.findViewById(R.id.t5_1);
        view5_2 = view.findViewById(R.id.t5_2);
        view5_3 = view.findViewById(R.id.t5_3);
        view5_4 = view.findViewById(R.id.t5_4);
        view5_5 = view.findViewById(R.id.t5_5);
        view5_6 = view.findViewById(R.id.t5_6);
        view5_7 = view.findViewById(R.id.t5_7);

        view6_1 = view.findViewById(R.id.t6_1);
        view6_2 = view.findViewById(R.id.t6_2);
        view6_3 = view.findViewById(R.id.t6_3);
        view6_4 = view.findViewById(R.id.t6_4);
        view6_5 = view.findViewById(R.id.t6_5);
        view6_6 = view.findViewById(R.id.t6_6);
        view6_7 = view.findViewById(R.id.t6_7);

        view7_1 = view.findViewById(R.id.t7_1);
        view7_2 = view.findViewById(R.id.t7_2);
        view7_3 = view.findViewById(R.id.t7_3);
        view7_4 = view.findViewById(R.id.t7_4);
        view7_5 = view.findViewById(R.id.t7_5);
        view7_6 = view.findViewById(R.id.t7_6);
        view7_7 = view.findViewById(R.id.t7_7);

        view8_1 = view.findViewById(R.id.t8_1);
        view8_2 = view.findViewById(R.id.t8_2);
        view8_3 = view.findViewById(R.id.t8_3);
        view8_4 = view.findViewById(R.id.t8_4);
        view8_5 = view.findViewById(R.id.t8_5);
        view8_6 = view.findViewById(R.id.t8_6);
        view8_7 = view.findViewById(R.id.t8_7);

        view9_1 = view.findViewById(R.id.t9_1);
        view9_2 = view.findViewById(R.id.t9_2);
        view9_3 = view.findViewById(R.id.t9_3);
        view9_4 = view.findViewById(R.id.t9_4);
        view9_5 = view.findViewById(R.id.t9_5);
        view9_6 = view.findViewById(R.id.t9_6);
        view9_7 = view.findViewById(R.id.t9_7);

        view10_1 = view.findViewById(R.id.t10_1);
        view10_2 = view.findViewById(R.id.t10_2);
        view10_3 = view.findViewById(R.id.t10_3);
        view10_4 = view.findViewById(R.id.t10_4);
        view10_5 = view.findViewById(R.id.t10_5);
        view10_6 = view.findViewById(R.id.t10_6);
        view10_7 = view.findViewById(R.id.t10_7);
        table();
        Button button = view.findViewById(R.id.up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Up_TableActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void table() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                Connection connection = null;
                PreparedStatement ps = null;
                ResultSet resultSet = null;
                List<Work> workList = new ArrayList<>();
                try {
                    String sql = "select * from work";
                    connection = DBConnection.getConnection();
                    ps = connection.prepareStatement(sql);
                    resultSet = ps.executeQuery();
                    while (resultSet.next()) {
                        Work work = new Work();
                        work.setMonday(resultSet.getString(1));
                        work.setTuesday(resultSet.getString("tuesday"));
                        work.setWednesday(resultSet.getString("wednesday"));
                        work.setThursday(resultSet.getString("thursday"));
                        work.setFriday(resultSet.getString("friday"));
                        work.setSaturday(resultSet.getString("saturday"));
                        work.setSunday(resultSet.getString("sunday"));
                        workList.add(work);
                    }
                    Message message = handler.obtainMessage();
                    message.obj = workList;
                    handler.sendMessage(message);
                    DBConnection.colse(resultSet, ps, connection);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                works = workList;
            }
        }.start();
    }
    public static List<Work> works;

    private Handler handler = new Handler() {
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            List<Work> works = (List<Work>) msg.obj;

            view1_1.setText(works.get(0).getMonday());
            view1_2.setText(works.get(0).getTuesday());
            view1_3.setText(works.get(0).getWednesday());
            view1_4.setText(works.get(0).getThursday());
            view1_5.setText(works.get(0).getFriday());
            view1_6.setText(works.get(0).getSaturday());
            view1_7.setText(works.get(0).getSunday());

            view2_1.setText(works.get(1).getMonday());
            view2_2.setText(works.get(1).getTuesday());
            view2_3.setText(works.get(1).getWednesday());
            view2_4.setText(works.get(1).getThursday());
            view2_5.setText(works.get(1).getFriday());
            view2_6.setText(works.get(1).getSaturday());
            view2_7.setText(works.get(1).getSunday());

            view3_1.setText(works.get(2).getMonday());
            view3_2.setText(works.get(2).getTuesday());
            view3_3.setText(works.get(2).getWednesday());
            view3_4.setText(works.get(2).getThursday());
            view3_5.setText(works.get(2).getFriday());
            view3_6.setText(works.get(2).getSaturday());
            view3_7.setText(works.get(2).getSunday());

            view4_1.setText(works.get(3).getMonday());
            view4_2.setText(works.get(3).getTuesday());
            view4_3.setText(works.get(3).getWednesday());
            view4_4.setText(works.get(3).getThursday());
            view4_5.setText(works.get(3).getFriday());
            view4_6.setText(works.get(3).getSaturday());
            view4_7.setText(works.get(3).getSunday());

            view5_1.setText(works.get(4).getMonday());
            view5_2.setText(works.get(4).getTuesday());
            view5_3.setText(works.get(4).getWednesday());
            view5_4.setText(works.get(4).getThursday());
            view5_5.setText(works.get(4).getFriday());
            view5_6.setText(works.get(4).getSaturday());
            view5_7.setText(works.get(4).getSunday());

            view6_1.setText(works.get(5).getMonday());
            view6_2.setText(works.get(5).getTuesday());
            view6_3.setText(works.get(5).getWednesday());
            view6_4.setText(works.get(5).getThursday());
            view6_5.setText(works.get(5).getFriday());
            view6_6.setText(works.get(5).getSaturday());
            view6_7.setText(works.get(5).getSunday());

            view7_1.setText(works.get(6).getMonday());
            view7_2.setText(works.get(6).getTuesday());
            view7_3.setText(works.get(6).getWednesday());
            view7_4.setText(works.get(6).getThursday());
            view7_5.setText(works.get(6).getFriday());
            view7_6.setText(works.get(6).getSaturday());
            view7_7.setText(works.get(6).getSunday());

            view8_1.setText(works.get(7).getMonday());
            view8_2.setText(works.get(7).getTuesday());
            view8_3.setText(works.get(7).getWednesday());
            view8_4.setText(works.get(7).getThursday());
            view8_5.setText(works.get(7).getFriday());
            view8_6.setText(works.get(7).getSaturday());
            view8_7.setText(works.get(7).getSunday());

            view9_1.setText(works.get(8).getMonday());
            view9_2.setText(works.get(8).getTuesday());
            view9_3.setText(works.get(8).getWednesday());
            view9_4.setText(works.get(8).getThursday());
            view9_5.setText(works.get(8).getFriday());
            view9_6.setText(works.get(8).getSaturday());
            view9_7.setText(works.get(8).getSunday());

            view10_1.setText(works.get(9).getMonday());
            view10_2.setText(works.get(9).getTuesday());
            view10_3.setText(works.get(9).getWednesday());
            view10_4.setText(works.get(9).getThursday());
            view10_5.setText(works.get(9).getFriday());
            view10_6.setText(works.get(9).getSaturday());
            view10_7.setText(works.get(9).getSunday());
        }
    };
}