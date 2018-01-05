package com.example.huaxie.chinesepoetry.fragments;

import com.example.huaxie.chinesepoetry.R;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class BaseFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        GridView poetryGridView = (GridView) view.findViewById(R.id.gridview_poetry);
        final List<String> testpoetry = Arrays.asList("离", "离", "原", "上","?",
                "一", "岁", "一", "枯", "?", "野","火","烧","不","?","春","风","吹","又","?");
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

        GridView wordlistView = (GridView) view.findViewById(R.id.words_list_grid_view);
        final List<String> testwords = Arrays.asList("草", "花", "树", "虫");
        wordlistView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return testwords.size();
            }

            @Override
            public Object getItem(int i) {
                return testwords.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(final int i, View view, ViewGroup viewGroup) {
                View container = (view != null ? view : inflater.inflate(R.layout.word_view, viewGroup, false));
                ((TextView)container.findViewById(R.id.word)).setText(testwords.get(i));
                final TextView word = (TextView) container.findViewById(R.id.word);
                final Drawable drawableTop = word.getBackground();
                drawableTop.setColorFilter(ContextCompat.getColor(getContext(), R.color.blue), PorterDuff.Mode.SRC_IN);
                word.setBackground(drawableTop);
                container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if(i == 0) {
                                drawableTop.setColorFilter(ContextCompat.getColor(getContext(), R.color.green), PorterDuff.Mode.SRC_IN);
                                word.setBackground(drawableTop);
                            }
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            Ringtone r = RingtoneManager.getRingtone(getContext(), notification);
                            r.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return container;
            }
        });
        return view;
    }

    public static BaseFragment newInstance() {
        return new BaseFragment();
    }
}
