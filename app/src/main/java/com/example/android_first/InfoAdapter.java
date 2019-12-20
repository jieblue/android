package com.example.android_first;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter {
    private ArrayList<Info> infos;//
    private Context context;//
    private OnItemClickListener itemClickListener;//点击接口
    public InfoAdapter(@NonNull Context context1, ArrayList<Info> arrayList) {
        context=context1;
        infos=arrayList;
    }
    public interface OnItemClickListener
    {
        void onLongClick(int Position);//长按接口
    }
    public void setItemClickListener(OnItemClickListener onItemClickListener)//设置长按接口
    {
        this.itemClickListener=onItemClickListener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v=LayoutInflater.from(context).inflate(R.layout.myitem,parent,false);
        return new InfoHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        InfoHolder infoHolder=(InfoHolder) holder;
        infoHolder.textView.setText(infos.get(position).getContent());
        if (itemClickListener!=null)
        {
            infoHolder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemClickListener.onLongClick(position);
                    return  false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }
    class InfoHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public InfoHolder(View view)
        {
            super(view);
            textView=view.findViewById(R.id.tv_item);
        }
    }
}
