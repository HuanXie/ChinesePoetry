package com.example.huaxie.chinesepoetry.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.huaxie.chinesepoetry.R;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder> {
    private Context context;
    private List<String> dataList;

    public WordsAdapter(Context context,List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.word.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView word;
        public MyViewHolder(View itemView) {
            super(itemView);
            word = (TextView) itemView.findViewById(R.id.word);
            Drawable drawableTop = word.getBackground();
            drawableTop.setColorFilter(ContextCompat.getColor(context, R.color.blue), PorterDuff.Mode.SRC_IN);
            word.setBackground(drawableTop);
        }
    }
}
