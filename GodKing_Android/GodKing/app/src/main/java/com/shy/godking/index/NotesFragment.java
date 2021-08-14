package com.shy.godking.index;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.shy.godking.R;
import com.shy.godking.jdbc.DBConnection;
import com.shy.godking.jdbc.User;
import com.shy.godking.list.Bean;
import com.shy.godking.list.MyAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotesFragment newInstance(String param1, String param2) {
        NotesFragment fragment = new NotesFragment();
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

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        recyclerView = view.findViewById(R.id.rv);
        query();
        Button button = view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Add_NotesActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public void query(){
        new Thread(){
            @Override
            public void run() {
                super.run();
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
                    Message message = handler.obtainMessage();
                    message.obj = beans;
                    handler.sendMessage(message);
                    DBConnection.colse(resultSet,ps,connection);
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }.start();
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            List<Bean> data = (List<Bean>) msg.obj;

            GridLayoutManager manager = new GridLayoutManager(getContext(),1);
            recyclerView.setLayoutManager(manager);
            MyAdapter adapter = new MyAdapter(data,getContext());

            recyclerView.setAdapter(adapter);
            adapter.setOnRecyclerItemClick(new MyAdapter.OnRecyclerItemClick() {
                @Override
                public void OnRecyclerItemClick(int position) {
                    Intent intent = new Intent(getActivity(),NotesItemActivity.class);
                    intent.putExtra("title",data.get(position).getTitle());
                    intent.putExtra("id",data.get(position).getId());
                    intent.putExtra("date",data.get(position).getData());
                    intent.putExtra("con",data.get(position).getContent());
                    startActivity(intent);
                }
            });

        }
    };
}