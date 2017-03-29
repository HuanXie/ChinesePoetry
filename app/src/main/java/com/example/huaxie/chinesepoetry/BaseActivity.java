package com.example.huaxie.chinesepoetry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.huaxie.chinesepoetry.adapters.WordsAdapter;

import java.util.Arrays;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        List<String> poetryTextList1 = Arrays.asList(new String[]{"离", "离", "原", "上", "草","离", "离", "原", "上", "草"});
        WordsAdapter wordsAdapter = new WordsAdapter(poetryTextList1);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.poetry_recylerview);
        recyclerView.setAdapter(wordsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,5, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
