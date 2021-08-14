package com.shy.godking.list;

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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bean> data;
    private Context context;

    public MyAdapter(List<Bean> data, Context context) {
        this.data = data;

        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.list_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getData());
        holder.textView1.setText(data.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return data==null ? 0 : data.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView textView1;
        private LinearLayout linearLayout;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item1);
            textView1 = itemView.findViewById(R.id.item2);
            linearLayout = itemView.findViewById(R.id.ll);
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
