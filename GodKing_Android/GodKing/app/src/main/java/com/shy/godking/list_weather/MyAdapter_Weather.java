package com.shy.godking.list_weather;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shy.godking.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyAdapter_Weather extends RecyclerView.Adapter<MyAdapter_Weather.MyViewHolder> {

    private List<Weather> data;
    private Context context;

    public MyAdapter_Weather(List<Weather> data, Context context) {
        this.data = data;

        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_weather,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getHour());
        holder.textView1.setText(data.get(position).getTemperature());
        holder.textView2.setText(data.get(position).getWeather());

    }

    @Override
    public int getItemCount() {
        return data==null ? 0 : data.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView textView1;
        private TextView textView2;
        private LinearLayout linearLayout;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item1_weather);
            textView1 = itemView.findViewById(R.id.item2_weather);
            textView2 = itemView.findViewById(R.id.item3_weather);
            linearLayout = itemView.findViewById(R.id.ll_weather);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onRecyclerItemClick != null){
                        onRecyclerItemClick.OnRecyclerItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }


    private OnRecyclerItemClick onRecyclerItemClick;

    public void setOnRecyclerItemClick(OnRecyclerItemClick listener){
        onRecyclerItemClick = listener;
    }

    public interface OnRecyclerItemClick{
        void OnRecyclerItemClick(int position);
    }
}
