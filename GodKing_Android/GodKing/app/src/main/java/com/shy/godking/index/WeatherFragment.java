package com.shy.godking.index;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.LocationManager;
import android.net.NetworkInfo;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.shy.godking.R;
import com.shy.godking.list_weather.AddressUtils;
import com.shy.godking.list_weather.HourWeather;
import com.shy.godking.list_weather.MyAdapter_Weather;
import com.shy.godking.list_weather.NetWorkUtils;
import com.shy.godking.list_weather.W24h;
import com.shy.godking.list_weather.Weather;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeatherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeatherFragment newInstance(String param1, String param2) {
        WeatherFragment fragment = new WeatherFragment();
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
    TextView tw_j1;
    TextView tw_j2;
    TextView tw_j3;
    TextView tw_2;
    TextView tw_4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        recyclerView = view.findViewById(R.id.rv_weather);
        tw_j1 = view.findViewById(R.id.tw_j1);
        tw_j2 = view.findViewById(R.id.tw_j2);
        tw_j3 = view.findViewById(R.id.tw_j3);
        tw_2 = view.findViewById(R.id.tw_2);
        tw_4 = view.findViewById(R.id.tw_4);
        weather();
        return view;
    }

    public void weather() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                String map = AddressUtils.getCity("");
                List<Weather> data = new ArrayList<>();
                W24h w24h = new W24h();
                List<HourWeather> weatherList = w24h.w24h("e8e17d73c85f4019887d3faecfea4ada",map);
                for (int i = 0; i < weatherList.size(); i++) {
                    Weather weather = new Weather();
                    weather.setHour(weatherList.get(i).getHour());
                    weather.setWeather(weatherList.get(i).getWeather());
                    weather.setTemperature(weatherList.get(i).getTemperature());
                    data.add(weather);
                }

                Message message = handler.obtainMessage();
                message.obj = data;
                handler.sendMessage(message);

                Message message1 = handler1.obtainMessage();
                message1.obj = map;
                handler1.sendMessage(message1);
            }
        }.start();
    }

    private Handler handler1 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String map = (String) msg.obj;
            tw_2.setText(map);
        }
    };

    private Handler handler = new Handler() {
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            List<Weather> data = (List<Weather>) msg.obj;
            tw_4.setText(data.get(0).getTemperature());
            GridLayoutManager manager = new GridLayoutManager(getContext(), 1);
            recyclerView.setLayoutManager(manager);
            MyAdapter_Weather adapter = new MyAdapter_Weather(data, getContext());
            recyclerView.setAdapter(adapter);
            adapter.setOnRecyclerItemClick(new MyAdapter_Weather.OnRecyclerItemClick() {
                @Override
                public void OnRecyclerItemClick(int position) {
                    Toast.makeText(getContext(), "你点" + (position + 1), Toast.LENGTH_SHORT).show();
                }
            });
            int hour = Integer.parseInt(data.get(0).getHour());
            int temperature = Integer.parseInt(data.get(0).getTemperature());
            String weather = data.get(0).getWeather();
            if (6<=hour&&hour<=11){
                tw_j1.setText("早上好");
                if (temperature<=15){
                    tw_j2.setText("添加衣服，冷");
                    if (weather.equals("晴")){
                        tw_j3.setText("多穿衣服，建议出去走走");
                    }
                }else if (15<temperature&&temperature<=28){
                    tw_j2.setText("温度适宜");
                    if (weather.equals("晴")){
                        tw_j3.setText("建议出去走走");
                    }
                }else {
                    tw_j2.setText("温度高，注意防范");
                    if (weather.equals("晴")){
                        tw_j3.setText("注意防中暑，建议出去走走");
                    }
                }
            }else if (hour == 12){
                tw_j1.setText("中午好");
                if (temperature<=15){
                    tw_j2.setText("添加衣服，冷");
                }else if (15<temperature&&temperature<=28){
                    tw_j2.setText("温度适宜");
                }else {
                    tw_j2.setText("温度高，注意防范");
                }
            }else if (13<=hour&&hour<=18){
                tw_j1.setText("下午好");
                if (temperature<=15){
                    tw_j2.setText("添加衣服，冷");
                }else if (15<temperature&&temperature<=28){
                    tw_j2.setText("温度适宜");
                }else {
                    tw_j2.setText("温度高，注意防范");
                }
            }else if (19<=hour&&hour<=23){
                tw_j1.setText("晚上好");
                if (temperature<=15){
                    tw_j2.setText("添加衣服，冷");
                }else if (15<temperature&&temperature<=28){
                    tw_j2.setText("温度适宜");
                }else {
                    tw_j2.setText("温度高，注意防范");
                }
            } else {
                tw_j1.setText("凌晨了，您该睡觉了");
                if (temperature<=15){
                    tw_j2.setText("添加衣服，冷");
                }else if (15<temperature&&temperature<=28){
                    tw_j2.setText("温度适宜");
                }else {
                    tw_j2.setText("温度高，注意防范");
                }
            }




        }
    };
}