package com.example.huaxie.chinesepoetry.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.huaxie.chinesepoetry.R;
import com.example.huaxie.chinesepoetry.adapters.WordsAdapter;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class BaseFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        GridView poetryGridView = (GridView) view.findViewById(R.id.gridview_poetry);
        final List<String> testpoetry = Arrays.asList("离", "离", "原", "上","草",
                "一", "岁", "一", "枯", "荣", "野","火","烧","不","尽","春","风","吹","又","生");
        poetryGridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return testpoetry.size();
            }

            @Override
            public Object getItem(int position) {
                return testpoetry.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View container = (convertView != null ? convertView : inflater.inflate(R.layout.word_view, parent, false));
                ((TextView)container.findViewById(R.id.word)).setText(testpoetry.get(position));
                return container;
            }
        });

        RecyclerView wordlistView = (RecyclerView) view.findViewById(R.id.words_list_recycler_view);
        List<String> testwords = Arrays.asList("草", "花", "树", "虫", "鱼");
        wordlistView.setAdapter(new WordsAdapter(testwords));
        wordlistView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        return view;
    }

    public static BaseFragment newInstance() {
        return new BaseFragment();
    }
}
